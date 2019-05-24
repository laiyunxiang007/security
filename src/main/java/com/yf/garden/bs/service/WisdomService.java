package com.yf.garden.bs.service;

import com.yf.garden.bs.dao.EquipmentMapper;
import com.yf.garden.bs.dao.GardenMapper;
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
 * 创建时间 2019/4/28
 */
@Service
public class WisdomService {
    @Autowired
    private GardenMapper gardenMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;

    public ResponseResult getGardenData(String gardenId, String massifId, String gardenName) {
        ResponseResult responseResult = new ResponseResult();
        Map<String, Object> data = new HashMap<>();
        Integer id;
        try {
            //默认情况下
            if (StringUtil.isEmpty(gardenId)) {
                List<Map<String, String>> gardens = gardenMapper.getGardenList();
                data.put("gardens", gardens);
                responseResult.setData(data);
            } else if (!StringUtil.isEmpty(gardenId)) {
                id = Integer.valueOf(gardenId);
                Map<String, Object> gardenDetail = gardenMapper.getGardenDetail(id);
                //默认风速
                List<Map<String, Object>> windSpeeds = gardenMapper.getWindSpeeds(id);
                //fm1
                List<Map<String, Object>> fm1s = gardenMapper.getFm1Data(id);
                //作物分布
                List<Map<String, Object>> cropAreaTime = gardenMapper.getCropAreaTime(id);
                //农事活动数量（施肥）
                List<Map<String, Object>> FertilizeCount = gardenMapper.getFertilizeCount(id);
                //植保
                List<Map<String, Object>> PlantPro = gardenMapper.getPlantPro(id);
                //摄像头
                List<Map<String, Object>> cameras = gardenMapper.getCameras(id);
                //地块
                List<Map<String, Object>> massifs = gardenMapper.getMassif(id);
                //设备
                List<Map<String, Object>> equipmentaddress = gardenMapper.getEquipmentAddress(id);
                Integer equipmentCount = equipmentMapper.getEquipmentCount(id);
                List<Map<String, Object>> NowFm1 = equipmentMapper.getNowFm1ByGardenId(id);
                List<Map<String, Object>> NowFm2 = equipmentMapper.getNowFm2ByGardenId(id);
                data.put("gardenDetail", gardenDetail);
                data.put("fm2", windSpeeds);
                data.put("fm1", fm1s);
                data.put("cropAreaTime", cropAreaTime);
                data.put("FertilizeCount", FertilizeCount);
                data.put("PlantPro", PlantPro);
                data.put("cameras", cameras);
                data.put("equipmentCount", equipmentCount);
                data.put("massifs", massifs);
                data.put("equipmentaddress", equipmentaddress);
                data.put("NowFm1",NowFm1);
                data.put("NowFm2", NowFm2);
                responseResult.setData(data);
            }
//            else if (!StringUtil.isEmpty(massifId)) {
//                id = Integer.valueOf(gardenId);
//                Map<String, Object> gardenDetail = gardenMapper.getGardenDetail(id);
//                //默认风速
//                List<Map<String, Object>> windSpeeds = gardenMapper.getWindSpeeds(id);
//                //fm1
//                List<Map<String, Object>> fm1s = gardenMapper.getFm1Data(id);
//                //作物分布
//                List<Map<String, Object>> cropAreaTime = gardenMapper.getCropAreaTime(id);
//                //农事活动数量（施肥）
//                List<Map<String, Object>> FertilizeCount = gardenMapper.getFertilizeCount(id);
//                //植保
//                List<Map<String, Object>> PlantPro = gardenMapper.getPlantPro(id);
//                //摄像头
//                List<Map<String, Object>> cameras = gardenMapper.getCameras(id);
//                //设备
//                List<Map<String, Object>> equipmentaddress = gardenMapper.getEquipmentAddress(id);
//                Integer equipmentCount = equipmentMapper.getEquipmentCount(id);
//                data.put("gardenDetail", gardenDetail);
//                data.put("fm2", windSpeeds);
//                data.put("fm1s", fm1s);
//                data.put("cropAreaTime", cropAreaTime);
//                data.put("FertilizeCount", FertilizeCount);
//                data.put("PlantPro", PlantPro);
//                data.put("cameras", cameras);
//                data.put("equipmentCount", equipmentCount);
//                data.put("equipmentaddress", equipmentaddress);
//                responseResult.setData(data);
//            }
        } catch (Exception e) {
            responseResult.setStatus("500");
            responseResult.setMsg("获取种果园数据异常");
        }
        return responseResult;
    }


    public ResponseResult getFm2DataByGardenId(String type, String equipmentId) {
        ResponseResult responseResult = new ResponseResult();
        Map<String, Object> data = new HashMap<>();
        try {
            if (type.equalsIgnoreCase("FM1")) {
                List<Map<String, Object>> WeekFm1 = equipmentMapper.getWeekFm1(equipmentId);
                List<Map<String, Object>> NowFm1 = equipmentMapper.getNowFm1(equipmentId);
                data.put("WeekFm1",WeekFm1);
                data.put("NowFm1",NowFm1);
                responseResult.setData(data);
                return responseResult;
            } else if (type.equalsIgnoreCase("FM2")) {
                List<Map<String, Object>> WeekFm2 = equipmentMapper.getWeekFm2(equipmentId);
                List<Map<String, Object>> NowFm2 = equipmentMapper.getNowFm2(equipmentId);
                data.put("WeekFm2",WeekFm2);
                data.put("NowFm2",NowFm2);
                responseResult.setData(data);
                return responseResult;
            }
        } catch (Exception e) {
          responseResult.setStatus("500");
          responseResult.setMsg("获取设备数据异常");
        }
        return responseResult;
    }
}
