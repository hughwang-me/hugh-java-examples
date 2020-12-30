package com.uwjx.easyexceltesting.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.uwjx.easyexceltesting.dao.StaffInfoExcelDAO;
import com.uwjx.easyexceltesting.dto.StaffInfoExcelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/17 14:30
 */
@Slf4j
public class StaffInfoListener extends AnalysisEventListener<StaffInfoExcelDTO> {

    private List<StaffInfoExcelDTO> list = new ArrayList<>();

    private static final int BATCH_COUNT = 5;

    StaffInfoExcelDAO staffInfoExcelDAO;

    public StaffInfoListener(StaffInfoExcelDAO staffInfoExcelDAO) {
        this.staffInfoExcelDAO = staffInfoExcelDAO;
    }

    @Override
    public void invoke(StaffInfoExcelDTO staffInfoExcelDTO, AnalysisContext analysisContext) {
        log.warn("StaffInfoListener -> invoke : {}" , staffInfoExcelDTO.getName());
        list.add(staffInfoExcelDTO);
        if(list.size() > BATCH_COUNT){
            staffInfoExcelDAO.save(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.warn("StaffInfoListener -> doAfterAllAnalysed");
        doSaveList();
    }

    public void doSaveList(){
        staffInfoExcelDAO.save(list);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.warn("表头信息:{}" , JSON.toJSONString(headMap));
    }
}
