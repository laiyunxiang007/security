package com.yf.garden.bs.controller;

import com.yf.garden.bs.service.HomeService;
import com.yf.garden.common.dto.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bs/v1/home/count")
@Api(value = "大屏首页相关接口", description = "大屏首页相关接口")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @PostMapping("/fulldata/{type}")
    @ApiOperation("大屏首页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省,2-市", paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "address", value = "地址", paramType = "query", dataType = "String")
    })
    public ResponseResult getFullData(@PathVariable int type,String address, String variety) {
        return homeService.getFullData(type,address,variety);
    }

    @GetMapping("/pluckRanking")
    @ApiOperation("品种采摘量排行")
    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
    public ResponseResult countPluckRanking(int type) {
        return null;
    }
//
//    @GetMapping("sourceRegion")
//    @ApiOperation("主要溯源区域")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countSourceRegion(int type) {
//        return null;
//    }
//
//    @GetMapping("/autoDevice")
//    @ApiOperation("智能设备占比情况")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countAutoDevice(int type) {
//        return null;
//    }
//
//    @GetMapping("/sales")
//    @ApiOperation("作物产销趋势")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countPlantSales(int type) {
//        return null;
//    }
}
