package com.example.mybatisplus.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author GuoYang
 * @create 2022-09-25 18:59
 */
@Data
public class DeleteDTO {

    private Long id;
    private List<Long> ids;
}
