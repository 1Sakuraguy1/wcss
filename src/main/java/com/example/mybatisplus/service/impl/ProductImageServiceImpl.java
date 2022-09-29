package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.ProductImage;
import com.example.mybatisplus.mapper.ProductImageMapper;
import com.example.mybatisplus.model.dto.ProductDTO;
import com.example.mybatisplus.service.ProductImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品图片表 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-25
 */
@Service
public class ProductImageServiceImpl extends ServiceImpl<ProductImageMapper, ProductImage> implements ProductImageService {


}
