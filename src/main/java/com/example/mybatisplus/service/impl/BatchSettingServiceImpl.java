package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.utls.ExcelUtil;
import com.example.mybatisplus.model.domain.BatchSetting;
import com.example.mybatisplus.mapper.BatchSettingMapper;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.BatchSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 批次设定 服务实现类
 * </p>
 *
 * @author lxp
 * @since 2022-09-24
 */
@Service
public class BatchSettingServiceImpl extends ServiceImpl<BatchSettingMapper, BatchSetting> implements BatchSettingService {

    @Override
    public Page<BatchSetting> pageList(PageDTO pageDTO,BatchSetting batchSetting) {
        Page<BatchSetting> page = new Page<>(pageDTO.getPageNo(),pageDTO.getPageSize());
        QueryWrapper<BatchSetting> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("gmt_created");
        if (StringUtils.isNoneBlank(batchSetting.getName())){
            wrapper.like("name",batchSetting.getName());
        }
        if (StringUtils.isNoneBlank(batchSetting.getDifficultyLevel())){
            wrapper.eq("difficulty_level",batchSetting.getDifficultyLevel());

        }
        if (batchSetting.getActive() != null){
            wrapper.eq("active",batchSetting.getActive());
        }
        page = baseMapper.selectPage(page, wrapper);
        return page;
    }

    @Override
    public void export(HttpServletResponse response,BatchSetting batchSetting) throws IOException {
        QueryWrapper<BatchSetting> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("gmt_created");
        if (StringUtils.isNoneBlank(batchSetting.getName())){
            wrapper.like("name",batchSetting.getName());
        }
        if (StringUtils.isNoneBlank(batchSetting.getDifficultyLevel())){
            wrapper.eq("difficulty_level",batchSetting.getDifficultyLevel());

        }
        if (batchSetting.getActive() != null){
            wrapper.eq("active",batchSetting.getActive());
        }
        List<BatchSetting> list = baseMapper.selectList(wrapper);

//        // 创建一个excel对象
//        Workbook wb = new HSSFWorkbook();
//
//        //用excel创建sheet
//        Sheet sheet = wb.createSheet();
//        //用sheet创建row 参数为行号，以0开始
//        Row row = sheet.createRow(0);
//        // 用行创建单元格
//        Cell cell = row.createCell(0);
//        cell.setCellValue("批次名");
//
//        cell = row.createCell(1);
//        cell.setCellValue("申请开始");
//
//        cell = row.createCell(2);
//        cell.setCellValue("申请结束");
//
//        cell = row.createCell(3);
//        cell.setCellValue("选衣开始");
//
//        cell = row.createCell(4);
//        cell.setCellValue("申请结束");
//
//        cell = row.createCell(5);
//        cell.setCellValue("困难等级");

//        for (int i = 0;i<list.size();i++){
//            row = sheet.createRow(i+1);
//
//            cell = row.createCell(0);
//            cell.setCellValue(list.get(i).getName());
//
//            cell = row.createCell(1);
//            cell.setCellValue(list.get(i).getApplicationStartDate().toString());
//
//            cell = row.createCell(2);
//            cell.setCellValue(list.get(i).getApplicationEndDate().toString());
//
//            cell = row.createCell(3);
//            cell.setCellValue(list.get(i).getRegisterStartDate().toString());
//
//            cell = row.createCell(4);
//            cell.setCellValue(list.get(i).getRegisterEndDate().toString());
//
//            cell = row.createCell(5);
//            cell.setCellValue(list.get(i).getDifficultyLevel());
//        }

        // 把对象转成流
//        try {
            response.setContentType("application/vnd.ms-excelapplication/x-excel");
            response.setHeader("Content-Disposition","attachment;filename=xxx.xls");
        ExcelUtil.exportBatch(response,list);
//            wb.write(response.getOutputStream());
//            // io流到底是什么格式
//            wb.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
