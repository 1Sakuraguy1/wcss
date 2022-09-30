package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.WhitelistSetting;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 * 学校用户白名单设置 服务类
 * </p>
 *
 * @author lxp
 * @since 2022-09-23
 */
public interface WhitelistSettingService extends IService<WhitelistSetting> {

    WhitelistSetting login(WhitelistSetting whitelistSetting);

    void downloadTemplete(HttpServletResponse response);

    Map<String, Object> improtUser(MultipartFile file);

    Page<WhitelistSetting> getWhiteList(PageDTO pageDTO, WhitelistSetting whitelistSetting);
}
