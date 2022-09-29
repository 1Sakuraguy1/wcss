package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.KnrdService;
import com.example.mybatisplus.model.domain.Knrd;


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
@RequestMapping("/api/knrd")
public class KnrdController {

    private final Logger logger = LoggerFactory.getLogger( KnrdController.class );

    @Autowired
    private KnrdService knrdService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Knrd  knrd =  knrdService.getById(id);
        return JsonResponse.success(knrd);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        knrdService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateKnrd(Knrd  knrd) throws Exception {
        knrdService.updateById(knrd);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Knrd
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Knrd  knrd) throws Exception {
        knrdService.save(knrd);
        return JsonResponse.success(null);
    }
}

