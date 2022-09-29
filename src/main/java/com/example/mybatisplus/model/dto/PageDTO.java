package com.example.mybatisplus.model.dto;

import lombok.Data;

/**
 * @author GuoYang
 * @create 2022-09-24 12:57
 */

@Data
public class PageDTO {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
}
