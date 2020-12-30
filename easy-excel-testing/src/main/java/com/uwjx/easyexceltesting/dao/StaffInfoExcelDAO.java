package com.uwjx.easyexceltesting.dao;

import com.uwjx.easyexceltesting.dto.StaffInfoExcelDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/17 14:39
 */
@Slf4j
@Component
public class StaffInfoExcelDAO {

    List<StaffInfoExcelDTO> data = new ArrayList<>();

    public void save(List<StaffInfoExcelDTO> list){
        data.addAll(list);
    }

    public int getDataSize(){
        return data.size();
    }

    public List<StaffInfoExcelDTO> getData(){
        return data;
    }
}
