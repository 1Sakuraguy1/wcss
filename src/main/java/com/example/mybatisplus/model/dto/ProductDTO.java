package com.example.mybatisplus.model.dto;

import com.example.mybatisplus.model.domain.Product;
import com.example.mybatisplus.model.domain.ProductImage;
import lombok.Data;

import java.util.List;

/**
 * @author GuoYang
 * @create 2022-09-25 15:04
 */
@Data
public class ProductDTO extends Product {
    private List<ProductImage> imgs;
    private List<String> skus;
}
