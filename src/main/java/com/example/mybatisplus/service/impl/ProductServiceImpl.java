package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Product;
import com.example.mybatisplus.mapper.ProductMapper;
import com.example.mybatisplus.model.domain.ProductImage;
import com.example.mybatisplus.model.domain.Sku;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.model.dto.ProductDTO;
import com.example.mybatisplus.service.ProductImageService;
import com.example.mybatisplus.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 衣服款式表 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private SkuService skuService;

    @Override
    public void saveProduct(ProductDTO product) {
        baseMapper.insert(product);
        product.getImgs().forEach(img -> img.setProductId(product.getId()));
        List<Sku> skus = product.getSkus().stream().map(x -> new Sku().setName(x).setProductId(product.getId())).collect(Collectors.toList());
        productImageService.saveBatch(product.getImgs());
        skuService.saveBatch(skus);
    }

    @Override
    public Page<Product> myList(PageDTO pageDTO,Product product) {
        Page<Product> page = new Page<>(pageDTO.getPageNo(),pageDTO.getPageSize());
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("batch_id", product.getBatchId());
        page = baseMapper.selectPage(page,wrapper);
        page.getRecords().stream().forEach(x->{

            QueryWrapper<ProductImage> imageQueryWrapper = new QueryWrapper<>();
            imageQueryWrapper.eq("product_id",x.getId());
            List<ProductImage> imageList = productImageService.list(imageQueryWrapper);

            QueryWrapper<Sku> skuQueryWrapper = new QueryWrapper<>();
            skuQueryWrapper.eq("product_id",x.getId());
            List<Sku> skuList = skuService.list(skuQueryWrapper);

            x.setImages(imageList).setSkuList(skuList);
        });
        return page;
    }

}
