package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 衣服款式表
 * </p>
 *
 * @author lxp
 * @since 2022-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wcss_product")
@ApiModel(value="Product对象", description="衣服款式表")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty(value = "商品名称")
    @TableField("NAME")
    private String name;

            @ApiModelProperty(value = "商品编码")
    private String productNumber;

            @ApiModelProperty(value = "商品批次")
    private Long batchId;

            @ApiModelProperty(value = "男、女（数据字典）")
    private String gender;

            @ApiModelProperty(value = "商品描述")
    private String description;

            @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreated;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModified;

            // 商品图片，规格
    @TableField(exist = false)
    private List<ProductImage> images;

    @TableField(exist = false)
    private List<Sku> skuList;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
