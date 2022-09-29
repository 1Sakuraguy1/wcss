package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 申请表
 * </p>
 *
 * @author lxp
 * @since 2022-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wcss_application")
@ApiModel(value="Application对象", description="申请表")
public class Application extends Model<Application> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty(value = "批次ID")
    private Long batchId;

            @ApiModelProperty(value = "SKU id")
    private Long skuId;

            @ApiModelProperty(value = "产品id")
    private Long productId;

            @ApiModelProperty(value = "学生sn")
    private String sn;

            @ApiModelProperty(value = "学生姓名")
    @TableField("NAME")
    private String name;

            @ApiModelProperty(value = "性别数据字典")
    private String gender;

            @ApiModelProperty(value = "申请时间")
    private LocalDate applyDate;

            @ApiModelProperty(value = "学院sn")
    private String collegeSn;

            @ApiModelProperty(value = "学院名")
    private String collegeName;

            @ApiModelProperty(value = "专业sn")
    private String majorSn;

            @ApiModelProperty(value = "专业名")
    private String majorName;

            @ApiModelProperty(value = "班级sn")
    private String classSn;

            @ApiModelProperty(value = "班级名")
    private String className;

            @ApiModelProperty(value = "困难等级级别")
    private String difficultyLevel;

            @ApiModelProperty(value = "申请理由")
    private String applicationReason;

    private String auditComment;

            @ApiModelProperty(value = "当前节点code")
    private Integer currentNodeCode;

            @ApiModelProperty(value = "状态（数据字典）")
    @TableField("STATUS")
    private String status;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreated;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
