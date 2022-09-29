package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.common.utls.BaseConstant;
import com.example.mybatisplus.common.utls.ExcelUtil;
import com.example.mybatisplus.model.domain.Knrd;
import com.example.mybatisplus.model.domain.WhitelistSetting;
import com.example.mybatisplus.mapper.WhitelistSettingMapper;
import com.example.mybatisplus.service.KnrdService;
import com.example.mybatisplus.service.WhitelistSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 学校用户白名单设置 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-23
 */
@Service
public class WhitelistSettingServiceImpl extends ServiceImpl<WhitelistSettingMapper, WhitelistSetting> implements WhitelistSettingService {
@Autowired
    KnrdService knrdService;

    @Override
    public WhitelistSetting login(WhitelistSetting whitelistSetting) {
        QueryWrapper<WhitelistSetting> wrapper = new QueryWrapper<>();
        wrapper.eq("sn", whitelistSetting.getSn()).eq("password",whitelistSetting.getPassword());
        WhitelistSetting login = baseMapper.selectOne(wrapper);
        //查不到去白名单查

        if(login == null){
            QueryWrapper<Knrd> knrdQueryWrapper = new QueryWrapper<>();
            knrdQueryWrapper.eq("student_id", whitelistSetting.getSn()).eq("student_id",whitelistSetting.getPassword());
            List<Knrd> knrdList = knrdService.list(knrdQueryWrapper);
            if (knrdList.size()>0){
                Knrd knrd = knrdList.get(0);
                WhitelistSetting user = new WhitelistSetting()
                        .setName(knrd.getName())
                        .setSn(knrd.getStudentId())
                        .setPassword(knrd.getStudentId())
                        .setRoleId(BaseConstant.ROLE_STUDENT);
                baseMapper.insert(user);
                login = user;
            }

        }
        return login;
    }

    @Override
    public void downloadTemplete(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excelapplication/x-excel");
            response.setHeader("Content-Disposition","attachment;filename=xxx.xls");
            ExcelUtil.exportModel(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Object> improtUser(MultipartFile file) {
        Map<String,Object> map = new HashMap<>();
        // 判断上传的文件对不对
        try {
            ExcelUtil.checkFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error","文件不存在或格式错误");
            return map;
        }
        try {
            List<String[]> strings = ExcelUtil.readExcel(file);
            List<WhitelistSetting> list = new ArrayList<>();
            //第一行不要。因为是表头
            for (int i = 1;i<strings.size();i++){
                WhitelistSetting whitelistSetting = new WhitelistSetting()
                        .setSn(strings.get(i)[0])
                        .setPassword(strings.get(i)[0])
                        .setName(strings.get(i)[1])
                        .setRoleId(Long.valueOf(strings.get(i)[2]))
                        .setIsEnabled("是".equals(strings.get(i)[3]));
                list.add(whitelistSetting);
            }
            this.saveBatch(list);
            map.put("success","成功导入用户"+list.size() + "人");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
