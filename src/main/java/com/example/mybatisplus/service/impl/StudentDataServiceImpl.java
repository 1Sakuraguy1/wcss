package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.StudentData;
import com.example.mybatisplus.mapper.StudentDataMapper;
import com.example.mybatisplus.service.StudentDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-26
 */
@Service
public class StudentDataServiceImpl extends ServiceImpl<StudentDataMapper, StudentData> implements StudentDataService {

}
