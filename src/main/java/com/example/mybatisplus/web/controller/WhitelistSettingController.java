package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.model.domain.BatchSetting;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.WhitelistSettingService;
import com.example.mybatisplus.model.domain.WhitelistSetting;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2022-09-23
 * @version v1.0
 */
@Controller
@RequestMapping("/api/whitelistSetting")
public class WhitelistSettingController {

    private final Logger logger = LoggerFactory.getLogger( WhitelistSettingController.class );

    @Autowired
    private WhitelistSettingService whitelistSettingService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        WhitelistSetting  whitelistSetting =  whitelistSettingService.getById(id);
        return JsonResponse.success(whitelistSetting);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        whitelistSettingService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateWhitelistSetting(WhitelistSetting  whitelistSetting) throws Exception {
        whitelistSettingService.updateById(whitelistSetting);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建WhitelistSetting
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(WhitelistSetting  whitelistSetting) throws Exception {
        whitelistSettingService.save(whitelistSetting);
        return JsonResponse.success(null);
    }

    /**
     * 描述:创建WhitelistSetting的登录方法
     *
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse login(@RequestBody  WhitelistSetting  whitelistSetting) throws Exception {
        WhitelistSetting login = whitelistSettingService.login(whitelistSetting);
        if (login != null){
            //存当前用户的session
            SessionUtils.saveCurUser(login);
        }
        return JsonResponse.success(login);
    }

    /**
     * 下载模板
     * @param response
     */
    @RequestMapping("dowmloadTemplete")
    @ResponseBody
    public void dowmloadTemplete(HttpServletResponse response){
        whitelistSettingService.downloadTemplete(response);
    }

    /**
     * 导入数据
     */
    @RequestMapping("improtUser")
    @ResponseBody
    public JsonResponse improtUser(MultipartFile file){
        Map<String,Object> map = whitelistSettingService.improtUser(file);
        return JsonResponse.success(map);

    }

    /**
     *  查看白名单的列表
     */
    @RequestMapping("getWhiteList")
    @ResponseBody
    public JsonResponse getWhiteList(PageDTO pageDTO, WhitelistSetting whitelistSetting){
        Page<WhitelistSetting> page = whitelistSettingService.getWhiteList(pageDTO,whitelistSetting);
        return JsonResponse.success(page);

    }


}

