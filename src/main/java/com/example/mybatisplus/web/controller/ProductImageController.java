package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Product;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ProductImageService;
import com.example.mybatisplus.model.domain.ProductImage;


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
@RequestMapping("/api/productImage")
public class ProductImageController {

    private final Logger logger = LoggerFactory.getLogger( ProductImageController.class );

    @Autowired
    private ProductImageService productImageService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        ProductImage  productImage =  productImageService.getById(id);
        return JsonResponse.success(productImage);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        productImageService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateProductImage(ProductImage  productImage) throws Exception {
        productImageService.updateById(productImage);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建ProductImage
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(ProductImage  productImage) throws Exception {
        productImageService.save(productImage);
        return JsonResponse.success(null);
    }

}

