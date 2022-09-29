package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.UserManageService;
import com.example.mybatisplus.model.domain.UserManage;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2022-09-26
 * @version v1.0
 */
@Controller
@RequestMapping("/api/userManage")
public class UserManageController {

    private final Logger logger = LoggerFactory.getLogger( UserManageController.class );

    @Autowired
    private UserManageService userManageService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        UserManage  userManage =  userManageService.getById(id);
        return JsonResponse.success(userManage);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        userManageService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateUserManage(UserManage  userManage) throws Exception {
        userManageService.updateById(userManage);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建UserManage
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(UserManage  userManage) throws Exception {
        userManageService.save(userManage);
        return JsonResponse.success(null);
    }
}

