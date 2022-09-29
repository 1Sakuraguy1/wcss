package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.BatchSetting;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.PageDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 批次设定 服务类
 * </p>
 *
 * @author lxp
 * @since 2022-09-24
 */
public interface BatchSettingService extends IService<BatchSetting> {

    Page<BatchSetting> pageList(PageDTO pageDTO,BatchSetting batchSetting);

    void export(HttpServletResponse response,BatchSetting batchSetting) throws IOException;
}
