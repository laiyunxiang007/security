package com.yf.garden.bs.service;

import com.yf.garden.bs.dao.ProvcityMapper;
import com.yf.garden.common.dto.ResponseResult;
import com.yf.garden.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/24
 */
@Service
public class PlantService {
    @Autowired
    private ProvcityMapper provcityMapper;

    /**
     * 种植总体数据
     *
     * @param
     * @return
     * @author bee
     * @date 2019/4/24 13:50
     */
    public ResponseResult countPlantTotal(int type, String address, String variety) {
        ResponseResult responseResult = new ResponseResult();
        Map<String,Object> data = new HashMap<>();
        try {

            //全国
            if (StringUtil.isEmpty(address) && type == 0) {
                //全国种植面积
                List<Map<String, String>> NationcityAreaList = provcityMapper.getAllProvcity(variety);
                //全国果园个数，果园面积，作物种类
                Map<String, String> NationAggregateData = provcityMapper.getNationWideData(variety);
                //全国农作物树龄分布
                List<Map<String, Object>> NationWideTreeAge = provcityMapper.getNationWideTreeAge(variety);

                //全国果园种植排名
                List<Map<String, String>> NationRanking = provcityMapper.getNationRanking(variety);
                //主要种植品种面积分布
                List<Map<String, String>> NationTypeArea = provcityMapper.getNationTypeArea(variety);
                //全国果园种植品质分布
                List<Map<String, String>> NationLevel = provcityMapper.getNationLevel(variety);
                data.put("AreaList",NationcityAreaList);
                data.put("AggregateData",NationAggregateData);
                data.put("TreeAge",NationWideTreeAge);
                data.put("Ranking",NationRanking);
                data.put("TypeArea",NationTypeArea);
                data.put("Level",NationLevel);
                responseResult.setData(data);
                return responseResult;
            }
            //全省
            else if (type == 1) {
                List<Map<String, String>> CityAreaList = provcityMapper.getAllCity(address, variety);
                //全省果园个数，果园面积，作物种类
                Map<String, String> AllCityAggregateData = provcityMapper.getAllCityAggregateData(address, variety);
                //全省农作物树龄分布
                List<Map<String, String>> ProvTreeAge = provcityMapper.getProvTreeAge(address, variety);
                //全省果园种植排名
                List<Map<String, String>> ProvRanking = provcityMapper.getProvRanking(address, variety);
                //全省主要种植品种面积分布
                List<Map<String, String>> ProvTypeArea = provcityMapper.getProvTypeArea(address, variety);
                //全省果园种植品质分布
                List<Map<String, String>> ProvLevel = provcityMapper.getProvLevel(address, variety);
                data.put("AreaList",CityAreaList);
                data.put("AggregateData",AllCityAggregateData);
                data.put("Ranking",ProvRanking);
                data.put("TreeAge",ProvTreeAge);
                data.put("TypeArea",ProvTypeArea);
                data.put("Level",ProvLevel);
                responseResult.setData(data);
                return responseResult;
            }
            //全市
            else if (type == 2) {
                List<Map<String, String>> CityArea = provcityMapper.getCityArea(address, variety);
                //全市果园个数，果园面积，作物种类
                Map<String, String> CityAggregateData = provcityMapper.getCityAggregateData(address, variety);
                //全市农作物树龄分布
                List<Map<String, String>> CityTreeAge = provcityMapper.getCityTreeAge(address, variety);
                //全市果园种植排名
                List<Map<String, String>> CityRanking = provcityMapper.getCityRanking(address, variety);
                //全市主要种植品种面积分布
                List<Map<String, String>> CityTypeArea = provcityMapper.getCityTypeArea(address, variety);
                //全市果园种植品质分布
                List<Map<String, String>> CityLevel = provcityMapper.getCityLevel(address, variety);
                data.put("AggregateData",CityAggregateData);
                data.put("TreeAge",CityTreeAge);
                data.put("Ranking",CityRanking);
                data.put("TypeArea",CityTypeArea);
                data.put("AreaList",CityArea);
                data.put("Level",CityLevel);
                responseResult.setData(data);
                return responseResult;
            }
        } catch (Exception e) {
          responseResult.setStatus("500");
          responseResult.setData("获取种植分布数据异常");
        }
        return responseResult;
    }
}
