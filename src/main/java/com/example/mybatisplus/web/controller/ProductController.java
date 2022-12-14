package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.model.domain.WhitelistSetting;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.model.dto.ProductDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ProductService;
import com.example.mybatisplus.model.domain.Product;


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
@RequestMapping("/api/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger( ProductController.class );

    @Autowired
    private ProductService productService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Product  product =  productService.getById(id);
        return JsonResponse.success(product);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        productService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateProduct(Product  product) throws Exception {
        productService.updateById(product);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Product
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Product  product) throws Exception {
        productService.save(product);
        return JsonResponse.success(null);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse save(@RequestBody ProductDTO product) throws Exception {
        productService.saveProduct(product);
        return JsonResponse.success(true);
    }

    @RequestMapping(value = "pageList")
    @ResponseBody
    public JsonResponse pageList(PageDTO pageDTO,Product product) throws Exception {
        Page<Product> page = productService.myList(pageDTO,product);
//        WhitelistSetting curUser = SessionUtils.getCurUser();
        return JsonResponse.success(page);
    }

}

