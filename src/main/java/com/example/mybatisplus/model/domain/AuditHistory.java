package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 审核历史表
 * </p>
 *
 * @author lxp
 * @since 2022-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wcss_audit_history")
@ApiModel(value="AuditHistory对象", description="审核历史表")
public class AuditHistory extends Model<AuditHistory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long applicationId;

            @ApiModelProperty(value = "审核人sn")
    private String auditBy;

            @ApiModelProperty(value = "审核人姓名")
    private String auditorName;

            @ApiModelProperty(value = "审核意见")
    private String auditComment;

            @ApiModelProperty(value = "审核节点code")
    private Integer auditNodeCode;

            @ApiModelProperty(value = "审核节点名称")
    private String auditNodeName;

            @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

            @ApiModelProperty(value = "审核结果（数据字典）")
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
