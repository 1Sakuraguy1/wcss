package com.example.mybatisplus;

import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.BatchSetting;
import com.example.mybatisplus.service.AdminService;
import com.example.mybatisplus.service.BatchSettingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private AdminService adminService;
    @Test
    void contextLoads() {
        Admin byId = adminService.getById(1);
        System.out.println(byId);
    }

    @Autowired
    BatchSettingService batchSettingService;

    @Test
    void batch(){
        List<BatchSetting> list = new ArrayList<>();
        for (int i=0;i<=11;i++){
            BatchSetting batchSetting = new BatchSetting()
                    .setName("批次"+i).setApplicationStartDate(LocalDate.now())
                    .setApplicationEndDate(LocalDate.now()).
                    setRegisterStartDate(LocalDate.now())
                    .setRegisterEndDate(LocalDate.now())
                    .setDifficultyLevel("TSKN");
            list.add(batchSetting);
        }
        batchSettingService.saveBatch(list);
    }

}
