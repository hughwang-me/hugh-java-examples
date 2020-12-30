package com.uwjx.easyexceltesting.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.easyexceltesting.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/17 16:51
 */
@RestController
@Slf4j
@RequestMapping(value = "excel")
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @PostMapping(value = "read")
    public String read(@RequestParam(name = "excel" , required = false) MultipartFile file , @RequestBody(required = false) Map<String , Object> map){
        if(map != null){
            log.warn("map -> {}" , JSON.toJSONString(map));
        }
        if(file != null){
            log.warn("file name : {}" , file.getName());
            excelService.loadFromWeb(file);
        }else {
            return "缺少文件参数";
        }
        return "ok";
    }

    @PostMapping(value = "read1")
    public String read1(@RequestParam(name = "excel" , required = false) MultipartFile file  ){

        if(file != null){
            log.warn("file name : {}" , file.getName());
            excelService.loadFromWeb(file);
        }else {
            return "缺少文件参数";
        }
        return "ok";
    }

    @PostMapping(value = "read2")
    public String read2(@RequestBody(required = false) Map<String , Object> map){
        if(map != null){
            log.warn("map -> {}" , JSON.toJSONString(map));
        }
        return "ok";
    }
}
