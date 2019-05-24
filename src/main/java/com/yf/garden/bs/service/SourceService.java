package com.yf.garden.bs.service;

import com.yf.garden.bs.dao.ProvcityMapper;
import com.yf.garden.bs.dao.SourceMapper;
import com.yf.garden.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/27
 */@Service
public class SourceService {
     @Autowired
     private SourceMapper sourceMapper;
    @Autowired
    private ProvcityMapper provcityMapper;

    public ResponseResult getCountSourceDistributed(String variety, String date) {
        ResponseResult responseResult = new ResponseResult();
        Map<String, Object> data = new HashMap<>();
        try {
            //全国种植面积
            List<Map<String, String>> NationcityAreaList = provcityMapper.getAllProvcity(variety);
            List<Map<String, Object>> originCity = sourceMapper.getAllOriginCity(variety);
            List<Map<String, Object>> originCount =sourceMapper.getAllOriginCount(variety);
            List<Map<String, Object>> originAddress=sourceMapper.getAllOriginAddress(variety,date);
            data.put("AreaList",NationcityAreaList);
            data.put("originCity",originCity);
            data.put("originCount",originCount);
            data.put("originAddress",originAddress);
          responseResult.setData(data);
        } catch (Exception e) {
            responseResult.setStatus("500");
            responseResult.setData("获取溯源数据异常");
        }
        return responseResult;
    }
}
