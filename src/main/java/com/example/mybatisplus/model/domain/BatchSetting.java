package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 批次设定
 * </p>
 *
 * @author lxp
 * @since 2022-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wcss_batch_setting")
@ApiModel(value="BatchSetting对象", description="批次设定")
public class BatchSetting extends Model<BatchSetting> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty(value = "批次名称")
    @TableField("NAME")
    private String name;

            @ApiModelProperty(value = "申请开始时间")
    private LocalDate applicationStartDate;

            @ApiModelProperty(value = "申请结束时间")
    private LocalDate applicationEndDate;

            @ApiModelProperty(value = "登记开始时间")
    private LocalDate registerStartDate;

            @ApiModelProperty(value = "登记结束时间")
    private LocalDate registerEndDate;

            @ApiModelProperty(value = "困难等级级别")
    private String difficultyLevel;

            @ApiModelProperty(value = "是否删除")
            @TableLogic//开启逻辑删除
            @TableField("is_deleted") //绑定数据表中的字段
    private Boolean deleted;

            @ApiModelProperty(value = "当前批次")
    private Boolean active;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreated;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
