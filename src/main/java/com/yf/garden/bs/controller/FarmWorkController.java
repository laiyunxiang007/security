package com.yf.garden.bs.controller;

import com.yf.garden.bs.service.FarmWorkService;
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
@RequestMapping("/api/bs/v1/work/count")
@Api(value = "大屏农事活动相关接口", description = "大屏农事活动相关接口")
public class FarmWorkController {
    @Autowired
    private FarmWorkService farmWorkService;
    @PostMapping("/autoFertilization/{type}")
    @ApiOperation("果园智能施肥情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省,2-市", paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "address", value = "地址", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "variety", value = "品种", paramType = "query", dataType = "String")
    })
    public ResponseResult countAutoFertilization(@PathVariable int type,String address,String variety) {
        return farmWorkService.getCountAutoFertilization(type,address,variety);
    }

//    @GetMapping("/manualFertilization")
//    @ApiOperation("果园人工施肥情况")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countManualFertilization(int type) {
//        return null;
//    }
//
//    @GetMapping("/plantMaintain")
//    @ApiOperation("果园农事植保情况")
//    @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省", paramType = "query", dataType = "int")
//    public ResponseResult countPlantMaintain(int type) {
//        return null;
//    }
}
