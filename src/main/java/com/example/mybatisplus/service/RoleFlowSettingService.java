package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.RoleFlowSetting;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审核节点配置 服务类
 * </p>
 *
 * @author lxp
 * @since 2022-09-27
 */
public interface RoleFlowSettingService extends IService<RoleFlowSetting> {


    RoleFlowSetting getNodeByCurNodeCode(Integer currentNodeCode);
}
