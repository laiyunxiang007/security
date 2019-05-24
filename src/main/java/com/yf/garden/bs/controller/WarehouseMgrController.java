package com.yf.garden.bs.controller;

import com.yf.garden.bs.service.WarehouseMgrSerivce;
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
@RequestMapping("/api/bs/v1/warehouse/count")
@Api(value = "大屏仓管相关接口", description = "大屏仓管相关接口")
public class WarehouseMgrController {

    @Autowired
    private WarehouseMgrSerivce warehouseMgrSerivce;
    @PostMapping("/total/{type}")
    @ApiOperation("统计出入库数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型,0-全国,1-全省,2-市", paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "address", value = "地址", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "variety", value = "品种", paramType = "query", dataType = "String")
    })
    public ResponseResult countWarehouseTotal(@PathVariable int type, String address, String variety) {
        return  warehouseMgrSerivce.countWarehouseTotal(type,address,variety);
    }

//    @GetMapping("/year")
//    @ApiOperation("统计指定年份各月出入库数量")
//    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "类型,0-入库,1-出库", paramType = "query", dataType = "int"),
//            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "int")})
//    public ResponseResult countWarehouseByYear(int type, int year) {
//        return null;
//    }
//
//    @GetMapping("/history")
//    @ApiOperation("统计近几年出入库数量")
//    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "类型,0-入库,1-出库", paramType = "query", dataType = "int"),
//            @ApiImplicitParam(name = "num", value = "近几年", paramType = "query", dataType = "int")})
//    public ResponseResult countWarehouseHistory(int type, int num) {
//        return null;
//    }
}
