package com.yf.garden.bs.controller;

import com.yf.garden.bs.service.WisdomService;
import com.yf.garden.common.dto.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bs/v1/wisdom/count")
@Api(value = "大屏智慧园地相关接口", description = "app大屏智慧园地相关接口")
public class WisdomGardenController {
    @Autowired
    private WisdomService wisdomService;


    @PostMapping("/info")
    @ApiOperation("获取果园数据")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "gardenId", value = "果园ID", paramType = "query", dataType = "String"),
             @ApiImplicitParam(name = "massifId", value = "地块ID", paramType = "query", dataType = "String"),
             @ApiImplicitParam(name = "gardenName", value = "果园名称", paramType = "query", dataType = "String")
            })
    public ResponseResult getGardenData(String gardenId,String massifId,String gardenName) {
        return wisdomService.getGardenData(gardenId,massifId,gardenName);
    }



    @PostMapping("/getEquipmentData")
    @ApiOperation("获取设备数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", paramType = "query", dataType = "String",
                    value = "风速-windSpeeds，降雨量-rain ,土壤水份-soilmture,土壤温度—soiltemp," +
                            "空气温度-temp，空气湿度-humid，压强-pa，光照-sunlux")
    })
    public ResponseResult getFm1DataByGardenId( String type,String equipmentId) {
        return wisdomService.getFm2DataByGardenId(type,equipmentId);
    }


}
