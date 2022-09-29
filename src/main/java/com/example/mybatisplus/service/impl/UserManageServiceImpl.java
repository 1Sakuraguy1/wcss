package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.UserManage;
import com.example.mybatisplus.mapper.UserManageMapper;
import com.example.mybatisplus.service.UserManageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-26
 */
@Service
public class UserManageServiceImpl extends ServiceImpl<UserManageMapper, UserManage> implements UserManageService {

}
