package com.yf.garden.bs.service;

import com.yf.garden.bs.dao.FarmWorkMapper;
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
 * 创建时间 2019/4/26
 */
@Service
public class FarmWorkService {
    @Autowired
    private ProvcityMapper provcityMapper;
    @Autowired
    private FarmWorkMapper farmWorkMapper;

    public ResponseResult getCountAutoFertilization(int type, String address, String variety) {
        ResponseResult responseResult = new ResponseResult();
        Map<String, Object> data = new HashMap<>();
        try {
            //全国
            if (StringUtil.isEmpty(address) && type == 0) {
                //全国种植面积
                List<Map<String, String>> NationcityAreaList = provcityMapper.getAllProvcity(variety);
                //人工施肥情况
                List<Map<String, String>> NationcityFertilizeList = farmWorkMapper.getAllFertilize(variety);
                //人工施肥情况每月
                List<Map<String, String>> NationcityFertilizeByMouthList = farmWorkMapper.getAllFertilizeByMouth(variety);
                //农事植保情况
                List<Map<String, String>> NationcityPlantProList = farmWorkMapper.getNationPlantPro(variety);
                //农事植保情况每月
                List<Map<String, String>> NationcityPlantProByMouthList = farmWorkMapper.getNationPlantProByMouth(variety);
                data.put("AreaList", NationcityAreaList);
                data.put("FertilizeList", NationcityFertilizeList);
                data.put("FertilizeByMouthList", NationcityFertilizeByMouthList);
                data.put("PlantProList", NationcityPlantProList);
                data.put("PlantProByMouthList", NationcityPlantProByMouthList);
                responseResult.setData(data);
                return responseResult;
            }
            //全省
            else if (type == 1) {
                List<Map<String, String>> CityAreaList = provcityMapper.getAllCity(address, variety);
                //人工施肥情况
                List<Map<String, String>> ProvFertilizeList = farmWorkMapper.getProvFertilize(address,
                        variety);
                //人工施肥情况每月
                List<Map<String, String>> ProvFertilizeByMouthList = farmWorkMapper.getProvFertilizeByMouth(address, variety);
                //农事植保情况
                List<Map<String, String>> ProvPlantProList = farmWorkMapper.getProvPlantPro(address, variety);
                //农事植保情况每月
                List<Map<String, String>> ProvPlantProByMouthList = farmWorkMapper.getProvPlantProByMouth(address, variety);
                data.put("AreaList", CityAreaList);
                data.put("FertilizeList", ProvFertilizeList);
                data.put("FertilizeByMouthList", ProvFertilizeByMouthList);
                data.put("PlantProList", ProvPlantProList);
                data.put("PlantProByMouthList", ProvPlantProByMouthList);
                responseResult.setData(data);
                return responseResult;
            }
            //全市
            else if (type == 2) {
                List<Map<String, String>> CityArea = provcityMapper.getCityArea(address, variety);
                //人工施肥情况
                List<Map<String, String>> CityFertilizeList = farmWorkMapper.getCityFertilize(address,
                        variety);
                //人工施肥情况每月
                List<Map<String, String>> CityFertilizeByMouthList = farmWorkMapper.getCityFertilizeByMouth(address,
                        variety);
                //农事植保情况
                List<Map<String, String>> CityPlantProList = farmWorkMapper.getCityPlantPro(address, variety);
                //农事植保情况每月
                List<Map<String, String>> CityPlantProByMouthList = farmWorkMapper.getCityPlantProByMouth(address, variety);
                data.put("AreaList", CityArea);
                data.put("FertilizeList", CityFertilizeList);
                data.put("FertilizeByMouthList", CityFertilizeByMouthList);
                data.put("PlantProList", CityPlantProList);
                data.put("PlantProByMouthList",CityPlantProByMouthList);
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
