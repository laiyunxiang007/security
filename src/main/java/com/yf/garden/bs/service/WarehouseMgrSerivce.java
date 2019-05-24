package com.yf.garden.bs.service;

import com.yf.garden.bs.dao.EquipmentMapper;
import com.yf.garden.bs.dao.ProvcityMapper;
import com.yf.garden.bs.dao.WarehouseMgrMapper;
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
public class WarehouseMgrSerivce {
    @Autowired
    private WarehouseMgrMapper warehouseMgrMapper;
    @Autowired
    private ProvcityMapper provcityMapper;


    public ResponseResult countWarehouseTotal(int type, String address, String variety) {
        ResponseResult responseResult = new ResponseResult();
        Map<String,Object> data = new HashMap<>();
        try {
            //全国
            if (StringUtil.isEmpty(address) && type == 0) {
                //全国种植面积
                List<Map<String, String>> NationcityAreaList = provcityMapper.getAllProvcity(variety);
                //入库
                Long NationInStock = warehouseMgrMapper.getInWarehouse(variety);
                //出库
                Long NationOutStock = warehouseMgrMapper.getOutWarehouse(variety);
                //今年入库
                List<Map<String,Object>> NationInStockThisYear = warehouseMgrMapper.getInWarehouseThisYear(variety);
                //今年出库
                List<Map<String,Object>> NationOutStockThisYear = warehouseMgrMapper.getOutWarehouseThisYear(variety);
                //去年入库
                List<Map<String,Object>> NationInStockLastYear = warehouseMgrMapper.getInWarehouseLastYear(variety);
                //去年出库
                List<Map<String,Object>> NationOutStockLastYear = warehouseMgrMapper.getOutWarehouseLastYear(variety);
                data.put("AreaList",NationcityAreaList);
                data.put("InStock",NationInStock);
                data.put("OutStock",NationOutStock);
                data.put("InStockThisYear",NationInStockThisYear);
                data.put("OutStockThisYear",NationOutStockThisYear);
                data.put("InStockLastYear",NationInStockLastYear);
                data.put("OutStockLastYear", NationOutStockLastYear);
                responseResult.setData(data);
                return responseResult;
            }
            //全省
            else if (type == 1) {
                List<Map<String, String>> CityAreaList = provcityMapper.getAllCity(address, variety);
                //入库
                Long ProInStock = warehouseMgrMapper.getInWarehouseByPro(address,variety);
                //出库
                Long ProOutStock = warehouseMgrMapper.getOutWarehouseByPro(address,variety);
                //今年入库
                List<Map<String,Object>> ProInStockThisYear = warehouseMgrMapper.getInWarehouseThisYearByPro(address,
                        variety);
                //今年出库
                List<Map<String,Object>> ProOutStockThisYear = warehouseMgrMapper.getOutWarehouseThisYearByPro(address,variety);
                //去年入库
                List<Map<String,Object>> ProInStockLastYear = warehouseMgrMapper.getInWarehouseLastYearByPro(address,variety);
                //去年出库
                List<Map<String,Object>> ProOutStockLastYear = warehouseMgrMapper.getOutWarehouseLastYearByPro(address,variety);

                data.put("AreaList",CityAreaList);
                data.put("InStock",ProInStock);
                data.put("OutStock",ProOutStock);
                data.put("InStockThisYear",ProInStockThisYear);
                data.put("OutStockThisYear",ProOutStockThisYear);
                data.put("InStockLastYear",ProInStockLastYear);
                data.put("OutStockLastYear",ProOutStockLastYear);
                responseResult.setData(data);
                return responseResult;
            }
            //全市
            else if (type == 2) {
                List<Map<String, String>> CityArea = provcityMapper.getCityArea(address, variety);
                //入库
                Long CityInStock = warehouseMgrMapper.getInWarehouseByCity(address,variety);
                //出库
                Long CityOutStock = warehouseMgrMapper.getOutWarehouseByCity(address,variety);
                //今年入库
                List<Map<String,Object>> CityInStockThisYear = warehouseMgrMapper.getInWarehouseThisYearByCity(address,
                        variety);
                //今年出库
                List<Map<String,Object>> CityOutStockThisYear = warehouseMgrMapper.getOutWarehouseThisYearByCity(address,variety);
                //去年入库
                List<Map<String,Object>> CityInStockLastYear = warehouseMgrMapper.getInWarehouseLastYearByCity(address,variety);
                //去年出库
                List<Map<String,Object>> CityOutStockLastYear = warehouseMgrMapper.getOutWarehouseLastYearByCity(address,variety);

                data.put("Area",CityArea);
                data.put("InStock",CityInStock);
                data.put("OutStock",CityOutStock);
                data.put("InStockThisYear",CityInStockThisYear);
                data.put("OutStockThisYear",CityOutStockThisYear);
                data.put("InStockLastYear",CityInStockLastYear);
                data.put("OutStockLastYear",CityOutStockLastYear);
                responseResult.setData(data);
                return responseResult;
            }
        } catch (Exception e) {
            responseResult.setStatus("500");
            responseResult.setData("获取出入库数据异常");
        }
        return responseResult;
    }

}
