package com.yf.garden.bs.controller;

import com.yf.garden.bs.service.PlantService;
import com.yf.garden.common.dto.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bs/v1/plant/count")
@Api(value = "大屏种植相关接口", description = "大屏种植相关接口")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @PostMapping("/total/{type}")
    @ApiOperation("种植总体数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省,2-市", paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "address", value = "地址", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "variety", value = "品种", paramType = "query", dataType = "String")
    })
    public ResponseResult countPlantTotal(@PathVariable("type") int type,String address,String variety) {
        return plantService.countPlantTotal(type,address,variety);
    }

//    @GetMapping("/distributed")
//    @ApiOperation("种植分布情况")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countPlantDistributed(int type) {
//        return null;
//    }
//
//    @GetMapping("/plantAge")
//    @ApiOperation("农作物树龄分布")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countPlantAgeDistributed(int type) {
//        return null;
//    }
//
//    @GetMapping("/plantArea")
//    @ApiOperation("主要农作物种植面积分布")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countPlantAreaDistributed(int type) {
//        return null;
//    }
//
//    @GetMapping("/gardenArea")
//    @ApiOperation("果园种植面积分布")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countGardenAreaDistributed(int type) {
//        return null;
//    }
//
//    @GetMapping("/gardenQuality")
//    @ApiOperation("果园种植品质分布")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countGardenQualityDistributed(int type) {
//        return null;
//    }
}
