package com.yf.garden.bs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/24
 */
@Mapper
public interface ProvcityMapper {

    List<Map<String, String>> getAllProvcity(@Param("variety") String variety);

    List<Map<String, String>> getAllCity(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityArea(String address,@Param("variety") String variety);


    Map<String, String> getCityAggregateData(String address,@Param("variety") String variety);

    Map<String, String> getAllCityAggregateData(String address, @Param("variety")String variety);
    //全国总数据
    Map<String, String> getNationWideData(@Param("variety")String variety);

    List<Map<String, Object>> getNationWideTreeAge(@Param("variety") String variety);

    List<Map<String, String>> getProvTreeAge(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityTreeAge(String address, @Param("variety")String variety);

    List<Map<String, String>> getNationRanking(@Param("variety")String variety);

    List<Map<String, String>> getProvRanking(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityRanking(String address,@Param("variety") String variety);

    List<Map<String, String>> getNationTypeArea(@Param("variety") String variety);

    List<Map<String, String>> getProvTypeArea(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityTypeArea(String address,@Param("variety") String variety);

    List<Map<String, String>> getNationLevel(@Param("variety") String variety);

    List<Map<String, String>> getProvLevel(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityLevel(String address,@Param("variety") String variety);


}
