package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxp
 * @since 2022-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("v_user_manage")
@ApiModel(value="UserManage对象", description="")
public class UserManage extends Model<UserManage> {

    private static final long serialVersionUID = 1L;

    @TableField("userName")
    private String userName;

    @TableField("userSn")
    private String userSn;

    @TableField("organizationId")
    private Long organizationId;

    @TableField("organizationName")
    private String organizationName;

    @TableField("organizationSN")
    private String organizationSN;

    @TableField("roleId")
    private Long roleId;

    @TableField("roleName")
    private String roleName;

    @TableField("organizationType")
    private Integer organizationType;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
