package com.yf.garden.bs.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/27
 */
@Mapper
public interface PluckMapper {
    List<Map<String, Object>> getPickRanking();

    List<Map<String, Object>> getPickRankingbyPro(String address);

    List<Map<String, Object>> getPickRankingbyCity(String address);
}
