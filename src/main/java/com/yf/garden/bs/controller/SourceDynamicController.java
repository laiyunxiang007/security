package com.yf.garden.bs.controller;

import com.yf.garden.bs.service.SourceService;
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
@RequestMapping("/api/bs/v1/source/count")
@Api(value = "大屏溯源动态相关接口", description = "大屏溯源动态相关接口")
public class SourceDynamicController {
    @Autowired
    private SourceService sourceService;
    @PostMapping("/distributed")
    @ApiOperation("统计溯源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "时间", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "variety", value = "品种", paramType = "query", dataType = "String")
    })
    public ResponseResult countSourceDistributed(String variety, String date) {
        return sourceService.getCountSourceDistributed(variety,date);
    }

//    @GetMapping("/times")
//    @ApiOperation("统计溯源次数")
//    @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "int")
//    public ResponseResult countSourceTimes(int year) {
//        return null;
//    }
//
//    @GetMapping("/address")
//    @ApiOperation("统计溯源地址")
//    @ApiImplicitParam(name = "date", value = "日期", paramType = "query", dataType = "string")
//    public ResponseResult countSourceAddress(String date) {
//        return null;
//    }
}
