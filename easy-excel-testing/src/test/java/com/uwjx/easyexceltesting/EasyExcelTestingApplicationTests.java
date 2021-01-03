package com.uwjx.easyexceltesting;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.uwjx.easyexceltesting.dto.DemoData;
import com.uwjx.easyexceltesting.util.TextUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import java.util.*;

@SpringBootTest
@Slf4j
class EasyExcelTestingApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void dynamicHeadWrite() {

        List<String> ignoreColumns = new ArrayList<>();
        ignoreColumns.add("key");
        ignoreColumns.add("_id");
        ignoreColumns.add("releaseStatus");
        ignoreColumns.add("confirmStatus");

        List<String> defaultColumns = new ArrayList<>();
        defaultColumns.add("工号");
        defaultColumns.add("姓名");
        defaultColumns.add("工资月份");
        defaultColumns.add("发布状态");
        defaultColumns.add("确认状态");

        List<String> exportColumns = new ArrayList<>();
        exportColumns.addAll(defaultColumns);

        Query query = new Query();
        query.addCriteria(Criteria.where("工号").regex(TextUtil.buildLikeRegex("03")));
        List<Map> queryResultMap = mongoTemplate.find(query, Map.class, "salary");
        log.warn("数据总数:{}" , queryResultMap.size());
        for (Map<String , String> map : queryResultMap) {
            for (String key : map.keySet()) {
                if(!ignoreColumns.contains(key) && !defaultColumns.contains(key)){
                    exportColumns.add(key);
                }
            }
        }
        log.warn("头个数 {}" , exportColumns.size());
        log.warn("{}" , JSON.toJSONString(exportColumns));

        List<List<Object>> exportList = new ArrayList<>();

        for (Map<String , String> map : queryResultMap) {
            List<Object> objectList = new ArrayList<>();
            for (String exportColumn : exportColumns) {
                if(map.containsKey(exportColumn)){
                    objectList.add(map.get(exportColumn));
                }else {
                    objectList.add("");
                }
            }
            exportList.add(objectList);
        }

        String fileName = "F:\\115\\1.xlsx";
        String sheetName = "职工工资";
        EasyExcel.write(fileName)
                .head(generateHeader(exportColumns)).sheet(sheetName)
                .doWrite(exportList);
    }

    private List<List<String>> generateHeader(List<String> exportColumns) {
        List<List<String>> headers = new ArrayList<List<String>>();
        for (String exportColumn : exportColumns) {
            List<String> head = new ArrayList<String>();
            head.add(exportColumn);
            headers.add(head);
        }
        return headers;
    }
}
