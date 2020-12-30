package com.uwjx.easyexceltesting.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.uwjx.easyexceltesting.dao.StaffInfoExcelDAO;
import com.uwjx.easyexceltesting.dto.StaffInfoExcelDTO;
import com.uwjx.easyexceltesting.excel.StaffInfoListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/17 14:27
 */
@Service
@Slf4j
public class ExcelService implements InitializingBean {

    @Autowired
    StaffInfoExcelDAO staffInfoExcelDAO;

    public void loadFromWeb(MultipartFile file){
        try {
            EasyExcel.read(file.getInputStream() , StaffInfoExcelDTO.class ,  new StaffInfoListener(staffInfoExcelDAO)).sheet("职工基本信息").doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.warn("读取到记录条数:{}" , staffInfoExcelDAO.getDataSize());
    }


    public void read(){
        log.warn("测试读取 Excel ");
        String filePathStr = "C:\\Users\\SalleyGardens\\Desktop\\职工信息 _模板.xlsx";
        log.warn("filePathStr => {}" , filePathStr);
        EasyExcel.read(filePathStr , StaffInfoExcelDTO.class ,  new StaffInfoListener(staffInfoExcelDAO)).sheet("职工基本信息").doRead();

        log.warn("读取到记录条数:{}" , staffInfoExcelDAO.getDataSize());

        for (StaffInfoExcelDTO dto : staffInfoExcelDAO.getData()) {
            log.warn("{}" , JSON.toJSONString(dto));
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        read();
    }
}
