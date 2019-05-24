package com.yf.garden.bs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/27
 */
@Mapper
public interface SourceMapper {
    List<Map<String, Object>> getAllOriginCity(@Param("variety") String variety);

    List<Map<String, Object>> getAllOriginCount(@Param("variety")String variety);

    List<Map<String, Object>> getAllOriginAddress(@Param("variety")String variety,@Param("date")String date);

    List<Map<String, Object>> getOriginCityByPro(String address,@Param("variety") String variety);

    List<Map<String, Object>> getOriginCityByCity(String address,@Param("variety") String variety);
}
