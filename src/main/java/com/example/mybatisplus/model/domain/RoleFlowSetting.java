package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 审核节点配置
 * </p>
 *
 * @author lxp
 * @since 2022-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wcss_role_flow_setting")
@ApiModel(value="RoleFlowSetting对象", description="审核节点配置")
public class RoleFlowSetting extends Model<RoleFlowSetting> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

            @ApiModelProperty(value = "节点编号")
    private Integer nodeCode;

            @ApiModelProperty(value = "节点名字")
    private String nodeName;

            @ApiModelProperty(value = "下一节点code")
    private Integer nextNode;

            @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreated;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
