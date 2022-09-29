package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.SkuService;
import com.example.mybatisplus.model.domain.Sku;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2022-09-25
 * @version v1.0
 */
@Controller
@RequestMapping("/api/sku")
public class SkuController {

    private final Logger logger = LoggerFactory.getLogger( SkuController.class );

    @Autowired
    private SkuService skuService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Sku  sku =  skuService.getById(id);
        return JsonResponse.success(sku);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        skuService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateSku(Sku  sku) throws Exception {
        skuService.updateById(sku);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Sku
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Sku  sku) throws Exception {
        skuService.save(sku);
        return JsonResponse.success(null);
    }
}

