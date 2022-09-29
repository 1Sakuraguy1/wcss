package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.model.dto.ProductDTO;

/**
 * <p>
 * 衣服款式表 服务类
 * </p>
 *
 * @author lxp
 * @since 2022-09-25
 */
public interface ProductService extends IService<Product> {

    void saveProduct(ProductDTO product);

    Page<Product> myList(PageDTO pageDTO,Product product);
}
