package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.RoleFlowSetting;
import com.example.mybatisplus.mapper.RoleFlowSettingMapper;
import com.example.mybatisplus.service.RoleFlowSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审核节点配置 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-27
 */
@Service
public class RoleFlowSettingServiceImpl extends ServiceImpl<RoleFlowSettingMapper, RoleFlowSetting> implements RoleFlowSettingService {

    @Override
    public RoleFlowSetting getNodeByCurNodeCode(Integer currentNodeCode) {
        QueryWrapper<RoleFlowSetting> wrapper = new QueryWrapper<>();
        wrapper.eq("node_code",currentNodeCode);
        RoleFlowSetting roleFlowSetting = baseMapper.selectOne(wrapper);
        return roleFlowSetting;
    }
}
