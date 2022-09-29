package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.utls.BaseConstant;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.model.domain.*;
import com.example.mybatisplus.mapper.ApplicationMapper;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 申请表 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-26
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {
@Autowired
    KnrdService knrdService;

@Autowired
    StudentDataService studentDataService;

@Autowired
    UserManageService userManageService;

@Autowired
    RoleFlowSettingService roleFlowSettingService;

@Autowired
    AuditHistoryService auditHistoryService;

    @Override
    public void mySave(Application application){
        //如果这个学生困难等级不满足批次等级怎么办？

        application.setApplyDate(LocalDate.now());

        //application里面只有批次id和申请理由，学生信息没有
        //学生信息需要去查
        //获取当前用户
        WhitelistSetting curUser = SessionUtils.getCurUser();
        // 从学生data表获取学生信息
        QueryWrapper<StudentData> studentDataQueryWrapper
                = new QueryWrapper<>();
        studentDataQueryWrapper.eq("sn",curUser.getSn());
        StudentData one = studentDataService.getOne(studentDataQueryWrapper);

        // 从困难等级表表获取学生信息 (应该加上学年）
        QueryWrapper<Knrd> knrdQueryWrapper = new QueryWrapper<>();
        knrdQueryWrapper.eq("student_id",curUser.getSn());
        List<Knrd> list = knrdService.list(knrdQueryWrapper);

        //开始赋值
        if (one != null){
            application.setClassName(one.getClazz())
                    .setClassSn(one.getClassCode())
                    .setCollegeName(one.getCollege())
                    .setCollegeSn(one.getCollegeCode())
                    .setMajorName(one.getMajor())
                    .setMajorSn(one.getMajorCode())
                    .setGender(one.getGender())
                    .setSn(one.getSn()).setName(one.getName());

        }
        if (list.size()>0){
            Knrd knrd = list.get(0);
            application.setDifficultyLevel(knrd.getPovertyLevel());
        }
        application.setCurrentNodeCode(BaseConstant.START_NODE_CODE);
        application.setStatus(BaseConstant.AUDIT_STATUS_DSH);
        baseMapper.insert(application);
    }

    @Override
    public Page<Application> myPage(PageDTO pageDTO,Application application){
        Page<Application> page = new Page<>(pageDTO.getPageNo(),pageDTO.getPageSize());
        //获取当前登录用户
        WhitelistSetting curUser = SessionUtils.getCurUser();
        //获取管辖范围
        QueryWrapper<UserManage> userManageQueryWrapper = new QueryWrapper<>();
        userManageQueryWrapper.eq("userSN",curUser.getSn()).eq("roleId",curUser.getRoleId());
        //管辖的范围
        List<UserManage> list = userManageService.list(userManageQueryWrapper);
        //管辖的范围的sn
        List<String> collect = list.stream().map(x -> x.getOrganizationSN()).collect(Collectors.toList());

        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        //辅导员
        if(BaseConstant.ROLE_TEACHER.equals(curUser.getRoleId())){
            //根绝组织sn查询待我审核
            wrapper.in("class_sn",collect)
                    .eq("current_node_code",BaseConstant.START_NODE_CODE)
                    .eq("status",BaseConstant.AUDIT_STATUS_DSH);
        }else if(BaseConstant.ROLE_COLLEGE.equals(curUser.getRoleId())){
            //学院
            //根绝组织sn查询待我审核
            wrapper.in("college_sn",collect)
                    .eq("current_node_code",BaseConstant.COLLEGE_NODE_CODE)
                    .eq("status",BaseConstant.AUDIT_STATUS_DSH);
        }else{
            //学校直接allin
            wrapper.eq("current_node_code",BaseConstant.SCHOOL_NODE_CODE)
                    .eq("status",BaseConstant.AUDIT_STATUS_DSH);
        }
        page = baseMapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public void audit(Application application) {
        // 根据审核状态判断是否进入下一个阶段
        // 把审核记录保存
        // 获取当前用户
        WhitelistSetting curUser = SessionUtils.getCurUser();
        Application app = baseMapper.selectById(application.getId());
        RoleFlowSetting curNode = roleFlowSettingService.getNodeByCurNodeCode(app.getCurrentNodeCode()); //获取当前节点
        AuditHistory auditHistory = new AuditHistory();
        // 辅导员
        if (BaseConstant.ROLE_TEACHER.equals(curUser.getRoleId())) {
            // 如果结果不通过，
            if (BaseConstant.AUDIT_STATUS_BTG.equals(application.getStatus())) {
                app.setStatus(app.getStatus()).setAuditComment(application.getAuditComment());
                //根据当前节点code获取信息
            } else {
                //通过
                //只需要更改当前节点为下一个节点,
                app.setCurrentNodeCode(BaseConstant.COLLEGE_NODE_CODE);
            }
        } else if (BaseConstant.ROLE_COLLEGE.equals(curUser.getRoleId())) { // 学院
            if (BaseConstant.AUDIT_STATUS_BTG.equals(application.getStatus())) {
                app.setStatus(app.getStatus()).setAuditComment(application.getAuditComment());
                //根据当前节点code获取信息
            } else {
                //通过
                //只需要更改当前节点为下一个节点
                app.setCurrentNodeCode(BaseConstant.SCHOOL_NODE_CODE);
            }
        } else { // 学校
            if (BaseConstant.AUDIT_STATUS_BTG.equals(application.getStatus())) {
                app.setStatus(app.getStatus()).setAuditComment(application.getAuditComment());
                //根据当前节点code获取信息
            } else {
                //通过
                //只需要更改当前节点为下一个节点,并且将状态改为通过
                app.setCurrentNodeCode(BaseConstant.END_NODE_CODE).setStatus(application.getStatus());

            }
        }
        baseMapper.updateById(app);
        auditHistory.setAuditBy(curUser.getSn())
                .setAuditorName(curUser.getName())
                .setAuditComment(application.getAuditComment())
                .setAuditNodeCode(app.getCurrentNodeCode())
                .setAuditNodeName(curNode.getNodeName())
                .setApplicationId(application.getId())
                .setStatus(application.getStatus());
        auditHistoryService.save(auditHistory);

    }

}
