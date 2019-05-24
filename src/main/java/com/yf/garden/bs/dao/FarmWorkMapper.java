package com.yf.garden.bs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/26
 */
@Mapper
public interface FarmWorkMapper {
    List<Map<String, String>> getAllFertilize(@Param("variety") String variety);

    List<Map<String, String>> getAllFertilizeByMouth(@Param("variety")String variety);

    List<Map<String, String>> getProvFertilize(String address, @Param("variety")String variety);

    List<Map<String, String>> getProvFertilizeByMouth(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityFertilize(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityFertilizeByMouth(String address,@Param("variety") String variety);

    List<Map<String, String>> getNationPlantPro(@Param("variety")String variety);

    List<Map<String, String>> getProvPlantPro(String address, @Param("variety")String variety);

    List<Map<String, String>> getCityPlantPro(String address, @Param("variety")String variety);

    List<Map<String, String>> getNationPlantProByMouth(@Param("variety")String variety);

    List<Map<String, String>> getProvPlantProByMouth(String address,@Param("variety") String variety);

    List<Map<String, String>> getCityPlantProByMouth(String address,@Param("variety") String variety);

    List<Map<String, Object>> getFertilizerByMouth();

    List<Map<String, Object>> getProFertilizerByMouth(String address);

    List<Map<String, Object>> getCityFertilizeityrByMouth(String address);
}
