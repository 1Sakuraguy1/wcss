package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * 学校用户白名单设置
 * </p>
 *
 * @author lxp
 * @since 2022-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wcss_whitelist_setting")
@ApiModel(value="WhitelistSetting对象", description="学校用户白名单设置")
public class WhitelistSetting extends Model<WhitelistSetting> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty(value = "限定用户SN")
    private String sn;

            @ApiModelProperty(value = "用户名")
    private String name;

            @ApiModelProperty(value = "用户角色id")
    private Long roleId;

    @TableField("is_enabled") //字段名绑定
    private Boolean isEnabled;

    @TableLogic
    @TableField("is_deleted") //字段名绑定
    private Boolean isDeleted;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreated;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModified;

    private String password;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
