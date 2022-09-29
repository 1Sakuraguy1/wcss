package com.example.mybatisplus.common.utls;

/**
 * @author GuoYang
 * @create 2022-09-26 1:57
 */
public interface BaseConstant {
    // 角色id 学生
    Long ROLE_STUDENT = 1L;

    // 角色id 辅导员
    Long ROLE_TEACHER = 4L;

    // 角色id 学院
    Long ROLE_COLLEGE = 3L;

    // 角色id 学校
    Long ROLE_SCHOOL = 2L;



    //审核开始节点
    Integer START_NODE_CODE = 1;

    //学院节点
    Integer COLLEGE_NODE_CODE = 2;

    //学校节点
    Integer SCHOOL_NODE_CODE = 3;

    //结束
    Integer END_NODE_CODE = 4;

    //审核状态
    String AUDIT_STATUS_DSH = "DSH";
    String AUDIT_STATUS_TG = "TG";
    String AUDIT_STATUS_BTG = "BTG";

//    String ALDIT_STATUS = 1 ;


}
