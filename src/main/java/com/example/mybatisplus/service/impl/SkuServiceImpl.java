package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Sku;
import com.example.mybatisplus.mapper.SkuMapper;
import com.example.mybatisplus.service.SkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品SKU表 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-25
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

}
