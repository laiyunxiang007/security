package com.yf.garden.bs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/26
 */
@Mapper
public interface WarehouseMgrMapper {
    Long getInWarehouse(@Param("variety") String variety);

    Long getOutWarehouse(@Param("variety") String variety);

    List<Map<String, Object>> getInWarehouseThisYear(@Param("variety") String variety);

    List<Map<String, Object>> getOutWarehouseThisYear(@Param("variety") String variety);

    List<Map<String, Object>> getInWarehouseLastYear(@Param("variety") String variety);

    List<Map<String, Object>> getOutWarehouseLastYear(@Param("variety") String variety);

    Long getInWarehouseByPro(String address, @Param("variety") String variety);

    Long getOutWarehouseByPro(String address, @Param("variety") String variety);

    List<Map<String, Object>> getInWarehouseThisYearByPro(String address, @Param("variety") String variety);

    List<Map<String, Object>> getOutWarehouseThisYearByPro(String address, @Param("variety") String variety);

    List<Map<String, Object>> getInWarehouseLastYearByPro(String address, @Param("variety") String variety);

    List<Map<String, Object>> getOutWarehouseLastYearByPro(String address, @Param("variety") String variety);

    Long getInWarehouseByCity(String address, @Param("variety") String variety);

    Long getOutWarehouseByCity(String address, @Param("variety") String variety);

    List<Map<String, Object>> getInWarehouseThisYearByCity(String address, @Param("variety") String variety);

    List<Map<String, Object>> getOutWarehouseThisYearByCity(String address, @Param("variety") String variety);

    List<Map<String, Object>> getInWarehouseLastYearByCity(String address, @Param("variety") String variety);

    List<Map<String, Object>> getOutWarehouseLastYearByCity(String address, @Param("variety") String variety);

    List<Map<String, Object>> getStock();

    List<Map<String, Object>> getStockByPro(String address);

    List<Map<String, Object>> getStockByCity(String address);

    @Select("SELECT SUM(od.dic_code) AS weight,date_format(ow.wh_cret_time,'%m') AS `mouth` FROM orchard_warehouse ow \n" +
            "LEFT JOIN orchard_dictionary od ON ow.wh_package_std=od.dic_id\n" +
            "WHERE date_format(ow.wh_cret_time,'%Y')=date_format(NOW(),'%Y') AND ow.wh_type=0 GROUP  BY date_format(ow.wh_cret_time,'%m')")
    List<Map<String, Object>> getInStock();

    @Select("SELECT SUM(od.dic_code) AS weight,date_format(ow.wh_cret_time,'%m') AS `mouth` FROM orchard_warehouse ow \n" +
            "LEFT JOIN orchard_dictionary od ON ow.wh_package_std=od.dic_id\n" +
            "WHERE date_format(ow.wh_cret_time,'%Y')=date_format(NOW(),'%Y') AND ow.wh_type=1 GROUP  BY date_format" +
            "(ow.wh_cret_time,'%m')")
    List<Map<String, Object>> getOutStock();

    @Select("SELECT SUM(od.dic_code) AS weight,date_format(ow.wh_cret_time,'%m') AS `mouth` FROM orchard_warehouse ow\n" +
            "LEFT JOIN orchard_dictionary od ON ow.wh_package_std=od.dic_id\n" +
            "LEFT JOIN orchard_address oa ON ow.wh_addr_id=oa.address_id\n" +
            "WHERE date_format(ow.wh_cret_time,'%Y')=date_format(NOW(),'%Y') AND ow.wh_type=0 GROUP  BY date_format(ow.wh_cret_time,'%m')\n" +
            "AND oa.address_prov=#{param1}")
    List<Map<String, Object>> getInStockByPro(String address);

    @Select("SELECT SUM(od.dic_code) AS weight,date_format(ow.wh_cret_time,'%m') AS `mouth` FROM orchard_warehouse ow \n" +
            "LEFT JOIN orchard_dictionary od ON ow.wh_package_std=od.dic_id\n" +
            "LEFT JOIN orchard_address oa ON ow.wh_addr_id=oa.address_id\n" +
            "WHERE date_format(ow.wh_cret_time,'%Y')=date_format(NOW(),'%Y') AND ow.wh_type=1 GROUP  BY date_format" +
            "(ow.wh_cret_time,'%m') AND oa.address_prov=#{param1}")
    List<Map<String, Object>> getOutStockByPro(String address);

    @Select("SELECT SUM(od.dic_code) AS weight,date_format(ow.wh_cret_time,'%m') AS `mouth` FROM orchard_warehouse ow\n" +
            "LEFT JOIN orchard_dictionary od ON ow.wh_package_std=od.dic_id\n" +
            "LEFT JOIN orchard_address oa ON ow.wh_addr_id=oa.address_id\n" +
            "WHERE date_format(ow.wh_cret_time,'%Y')=date_format(NOW(),'%Y') AND ow.wh_type=0 GROUP  BY date_format(ow.wh_cret_time,'%m')\n" +
            "AND oa.address_city=#{param1}")
    List<Map<String, Object>> getInStockByCity(String address);

    @Select("SELECT SUM(od.dic_code) AS weight,date_format(ow.wh_cret_time,'%m') AS `mouth` FROM orchard_warehouse ow \n" +
            "LEFT JOIN orchard_dictionary od ON ow.wh_package_std=od.dic_id\n" +
            "LEFT JOIN orchard_address oa ON ow.wh_addr_id=oa.address_id\n" +
            "WHERE date_format(ow.wh_cret_time,'%Y')=date_format(NOW(),'%Y') AND ow.wh_type=1 GROUP  BY date_format" +
            "(ow.wh_cret_time,'%m') AND oa.address_city=#{param1}")
    List<Map<String, Object>> getOutStockByCtiy(String address);
}
