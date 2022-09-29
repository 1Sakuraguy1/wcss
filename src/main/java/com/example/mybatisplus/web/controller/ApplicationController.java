package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ApplicationService;
import com.example.mybatisplus.model.domain.Application;


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
@RequestMapping("/api/application")
public class ApplicationController {

    private final Logger logger = LoggerFactory.getLogger( ApplicationController.class );

    @Autowired
    private ApplicationService applicationService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Application  application =  applicationService.getById(id);
        return JsonResponse.success(application);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        applicationService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateApplication(Application  application) throws Exception {
        applicationService.updateById(application);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Application
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Application  application) throws Exception {
        applicationService.save(application);
        return JsonResponse.success(null);
    }


    /**
     * 描述:创建Application
     *
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public JsonResponse save(@RequestBody Application  application) throws Exception {
        applicationService.mySave(application);
        return JsonResponse.success(true);
    }

    @RequestMapping(value = "/waitAudit")
    @ResponseBody
    public JsonResponse waitAudit(PageDTO pageDTO ,Application  application) throws Exception {
        Page<Application> page = applicationService.myPage(pageDTO,application);
        return JsonResponse.success(page);
    }

    /**
     * 审核
     * @return
     */
    @RequestMapping(value = "/audit")
    @ResponseBody
    public JsonResponse waitAudit(@RequestBody Application application){
        applicationService.audit(application);
        return JsonResponse.success(true);

    }

}

