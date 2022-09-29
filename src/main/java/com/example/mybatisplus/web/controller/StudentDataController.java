package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.StudentDataService;
import com.example.mybatisplus.model.domain.StudentData;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2022-09-26
 * @version v1.0
 */
@Controller
@RequestMapping("/api/studentData")
public class StudentDataController {

    private final Logger logger = LoggerFactory.getLogger( StudentDataController.class );

    @Autowired
    private StudentDataService studentDataService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        StudentData  studentData =  studentDataService.getById(id);
        return JsonResponse.success(studentData);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        studentDataService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateStudentData(StudentData  studentData) throws Exception {
        studentDataService.updateById(studentData);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建StudentData
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(StudentData  studentData) throws Exception {
        studentDataService.save(studentData);
        return JsonResponse.success(null);
    }
}

