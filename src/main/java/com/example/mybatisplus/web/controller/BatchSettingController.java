package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.dto.DeleteDTO;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.BatchSettingService;
import com.example.mybatisplus.model.domain.BatchSetting;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2022-09-24
 * @version v1.0
 */
@Controller
@RequestMapping("/api/batchSetting")
public class BatchSettingController {

    private final Logger logger = LoggerFactory.getLogger( BatchSettingController.class );

    @Autowired
    private BatchSettingService batchSettingService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        BatchSetting  batchSetting =  batchSettingService.getById(id);
        return JsonResponse.success(batchSetting);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        batchSettingService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateBatchSetting(BatchSetting  batchSetting) throws Exception {
        batchSettingService.updateById(batchSetting);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建BatchSetting
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(BatchSetting  batchSetting) throws Exception {
        batchSettingService.save(batchSetting);
        return JsonResponse.success(null);
    }


    /**
     * 分页查询
     * @param pageDTO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "pageList")
    @ResponseBody
    public JsonResponse pageList(PageDTO pageDTO,BatchSetting batchSetting) throws Exception {
        Page<BatchSetting> page = batchSettingService.pageList(pageDTO,batchSetting);
        return JsonResponse.success(page);
    }

    /**
     * 新建批次
     * @param batchSetting
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse save(@RequestBody BatchSetting batchSetting) throws Exception {
        boolean flag = batchSettingService.save(batchSetting);
        return JsonResponse.success(flag);
    }

    /**
     * 删除一条批次
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteById")
    @ResponseBody
    public JsonResponse delete(@RequestBody DeleteDTO deleteDTO) throws Exception {
        return JsonResponse.success(batchSettingService.removeById(deleteDTO.getId()));
    }

    /**
     * 删除多条记录
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deletes", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deletes(@RequestBody DeleteDTO deleteDTO) throws Exception {
        return JsonResponse.success(batchSettingService.removeByIds(deleteDTO.getIds()));
    }

    /** 导出excel
     *
     */
    @PostMapping("export")
    @ResponseBody
    public void export(HttpServletResponse response,@RequestBody BatchSetting batchSetting) throws IOException {
        batchSettingService.export(response,batchSetting);
    }



}

