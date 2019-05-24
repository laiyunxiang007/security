package com.yf.garden.bs.service;

import com.yf.garden.bs.dao.*;
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
 * 创建时间 2019/4/27
 */
@Service
public class HomeService {
    @Autowired
    private ProvcityMapper provcityMapper;
    @Autowired
    private SourceMapper sourceMapper;
    @Autowired
    private WarehouseMgrMapper warehouseMgrMapper;
    @Autowired
    private PluckMapper pluckMapper;
    @Autowired
    private FarmWorkMapper farmWorkMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;

    public ResponseResult getFullData(int type, String address,String variety) {
        ResponseResult responseResult = new ResponseResult();
        Map<String,Object> data = new HashMap<>();
        try {
            //全国
            if (StringUtil.isEmpty(address) && type == 0) {
                //全国种植面积
                List<Map<String, String>> NationcityAreaList = provcityMapper.getAllProvcity(variety);
                //全国果园个数，果园面积，作物种类
                Map<String, String> NationAggregateData = provcityMapper.getNationWideData(variety);
                //溯源
                List<Map<String, Object>> originNation = sourceMapper.getAllOriginCity(variety);
                //各品种库存
                List<Map<String, Object>> Stock=warehouseMgrMapper.getStock();
                //采摘排行榜
                List<Map<String, Object>> PickRanking=pluckMapper.getPickRanking();
                //施肥平均值
                List<Map<String, Object>> fertilizer= farmWorkMapper.getFertilizerByMouth();
                //设备
                List<Map<String, Object>> equipment= equipmentMapper.getEquipment();
                //入库
                List<Map<String, Object>> instock = warehouseMgrMapper.getInStock();
                //出库
                List<Map<String, Object>> outstock = warehouseMgrMapper.getOutStock();
                data.put("AreaList",NationcityAreaList);
                data.put("AggregateData",NationAggregateData);
                data.put("Origin",originNation);
                data.put("Stock",Stock);
                data.put("PickRanking",PickRanking);
                data.put("Fertilizer",fertilizer);
                data.put("Equipment",equipment);
                data.put("instock", instock);
                data.put("outstock", outstock);
                responseResult.setData(data);
                return responseResult;
            }
            //全省
            else if (type == 1) {
                List<Map<String, String>> CityAreaList = provcityMapper.getAllCity(address, variety);
                //全省果园个数，果园面积，作物种类
                Map<String, String> AllCityAggregateData = provcityMapper.getAllCityAggregateData(address, variety);
                //溯源
                List<Map<String, Object>> originPro = sourceMapper.getOriginCityByPro(address,variety);
                //各品种库存
                List<Map<String, Object>> ProStock=warehouseMgrMapper.getStockByPro(address);
                //采摘排行榜
                List<Map<String, Object>> ProPickRanking=pluckMapper.getPickRankingbyPro(address);
                //施肥平均值
                List<Map<String, Object>> ProFertilizer= farmWorkMapper.getProFertilizerByMouth(address);
                //设备
                List<Map<String, Object>> ProEquipment= equipmentMapper.getEquipmentByPro(address);
                //入库
                List<Map<String, Object>> instock = warehouseMgrMapper.getInStockByPro(address);
                //出库
                List<Map<String, Object>> outstock = warehouseMgrMapper.getOutStockByPro(address);
                data.put("AreaList",CityAreaList);
                data.put("AggregateData",AllCityAggregateData);
                data.put("Origin",originPro);
                data.put("Stock",ProStock);
                data.put("PickRanking",ProPickRanking);
                data.put("Fertilizer",ProFertilizer);
                data.put("Equipment",ProEquipment);
                data.put("instock", instock);
                data.put("outstock", outstock);
                responseResult.setData(data);
                return responseResult;
            }
            //全市
            else if (type == 2) {
                List<Map<String, String>> CityArea = provcityMapper.getCityArea(address, variety);
                //全市果园个数，果园面积，作物种类
                Map<String, String> CityAggregateData = provcityMapper.getCityAggregateData(address, variety);
                //溯源
                List<Map<String, Object>> originCity = sourceMapper.getOriginCityByCity(address,variety);
                //各品种库存
                List<Map<String, Object>> CityStock=warehouseMgrMapper.getStockByCity(address);
                //采摘排行榜
                List<Map<String, Object>> CityPickRanking=pluckMapper.getPickRankingbyCity(address);
                //施肥平均值ity
                List<Map<String, Object>> CityFertilizer= farmWorkMapper.getCityFertilizeityrByMouth(address);
                //设备
                List<Map<String, Object>> CityEquipment= equipmentMapper.getEquipmentByCity(address);
                //入库
                List<Map<String, Object>> instock = warehouseMgrMapper.getInStockByCity(address);
                //出库
                List<Map<String, Object>> outstock = warehouseMgrMapper.getOutStockByCtiy(address);
                data.put("AreaList",CityArea);
                data.put("AggregateData",CityAggregateData);
                data.put("Origin",originCity);
                data.put("Stock",CityStock);
                data.put("PickRanking",CityPickRanking);
                data.put("Fertilizer", CityFertilizer);
                data.put("Equipment", CityEquipment);
                data.put("instock", instock);
                data.put("outstock", outstock);
                responseResult.setData(data);
                return responseResult;
            }
        } catch (Exception e) {
            responseResult.setStatus("500");
            responseResult.setMsg("获取种植分布数据异常");
        }
        return responseResult;
    }
}
