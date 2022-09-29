package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("v_knrd")
@ApiModel(value="Knrd对象", description="")
public class Knrd extends Model<Knrd> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String className;

    private String collegeName;

    private String gradeName;

    private String majorName;

    private String name;

    private String povertyLevel;

    private String studentId;

    private String year;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
