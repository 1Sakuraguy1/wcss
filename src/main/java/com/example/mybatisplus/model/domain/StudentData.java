package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("v_student_data")
@ApiModel(value="StudentData对象", description="")
public class StudentData extends Model<StudentData> {

    private static final long serialVersionUID = 1L;

    private String sn;

    private String name;

    private String gender;

    private String nation;

    private String nationality;

    private String college;

    private String major;

    @TableField("class")
    private String clazz;

    private String collegeCode;

    private String majorCode;

    private String classCode;

    private String grade;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
