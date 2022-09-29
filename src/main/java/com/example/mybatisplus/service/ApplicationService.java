package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Application;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.PageDTO;

/**
 * <p>
 * 申请表 服务类
 * </p>
 *
 * @author lxp
 * @since 2022-09-26
 */
public interface ApplicationService extends IService<Application> {

    void mySave(Application application);


    Page<Application> myPage(PageDTO pageDTO,Application application);

    void audit(Application application);
}
