package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AuditHistoryService;
import com.example.mybatisplus.model.domain.AuditHistory;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2022-09-27
 * @version v1.0
 */
@Controller
@RequestMapping("/api/auditHistory")
public class AuditHistoryController {

    private final Logger logger = LoggerFactory.getLogger( AuditHistoryController.class );

    @Autowired
    private AuditHistoryService auditHistoryService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        AuditHistory  auditHistory =  auditHistoryService.getById(id);
        return JsonResponse.success(auditHistory);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        auditHistoryService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateAuditHistory(AuditHistory  auditHistory) throws Exception {
        auditHistoryService.updateById(auditHistory);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建AuditHistory
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(AuditHistory  auditHistory) throws Exception {
        auditHistoryService.save(auditHistory);
        return JsonResponse.success(null);
    }
}

