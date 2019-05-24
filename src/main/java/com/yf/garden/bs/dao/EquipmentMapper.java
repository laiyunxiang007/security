package com.yf.garden.bs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/4/27
 */
@Mapper
public interface EquipmentMapper {

    List<Map<String, Object>> getEquipment();

    List<Map<String, Object>> getEquipmentByPro(String address);

    List<Map<String, Object>> getEquipmentByCity(String address);

    Integer getEquipmentCount(Integer id);
    @Select("SELECT\n" +
            "            AVG(fmbdata_windspd) fmbdata_windspd,\n" +
            "            DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(fmbdata_txtime)\n" +
            "        AND fd.fmbdata_status='A'\n" +
            "        group by DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getWindSpeeds(String gardenId);
    @Select("SELECT\n" +
            "           AVG(fmbdata_rain) fmbdata_rain,\n" +
            "            DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(fmbdata_txtime)\n" +
            "        AND fd.fmbdata_status='A'\n" +
            "        group by DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getRain(String gardenId);
    @Select("SELECT\n" +
            "            AVG(fmbdata_soiltemp) fmbdata_soiltemp,\n" +
            "            DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(fmbdata_txtime)\n" +
            "        AND fd.fmbdata_status='A'\n" +
            "        group by DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getSoilmture(String gardenId);
    @Select("SELECT\n" +
            "           AVG(fmbdata_soilmture) fmbdata_soilmture,\n" +
            "            DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(fmbdata_txtime)\n" +
            "        AND fd.fmbdata_status='A'\n" +
            "        group by DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getSoiltemp(String gardenId);
    @Select("SELECT\n" +
            "            AVG(flddata_temp) flddata_temp,\n" +
            "            DATE_FORMAT(flddata_txtime,'%Y-%m-%d') days FROM fielddata f\n" +
            "            LEFT JOIN orchard_fielddstation of ON f.fldstn_id=of.fldstn_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(flddata_txtime)\n" +
            "        AND f.flddata_status='A'\n" +
            "        group by DATE_FORMAT(flddata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getTemp(String gardenId);
    @Select("SELECT\n" +
            "           AVG(flddata_humid) flddata_humid,\n" +
            "            DATE_FORMAT(flddata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(flddata_txtime)\n" +
            "        AND f.flddata_status='A'\n" +
            "        group by DATE_FORMAT(flddata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getHumid(String gardenId);
    @Select("SELECT\n" +
            "            AVG(flddata_pa) flddata_pa,\n" +
            "            DATE_FORMAT(flddata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(flddata_txtime)\n" +
            "        AND f.flddata_status='A'\n" +
            "        group by DATE_FORMAT(flddata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getPa(String gardenId);
    @Select("SELECT\n" +
            "           AVG(flddata_sunlux) flddata_sunlux,\n" +
            "            DATE_FORMAT(flddata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE og.garden_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) &lt;= date(flddata_txtime)\n" +
            "        AND f.flddata_status='A'\n" +
            "        group by DATE_FORMAT(flddata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getSunlux(String gardenId);

    @Select("SELECT AVG(flddata_humid) flddata_humid,AVG(flddata_temp) flddata_temp,AVG(flddata_sunlux) flddata_sunlux,\n" +
            "AVG(flddata_pa) flddata_pa,DATE_FORMAT(flddata_txtime,'%Y-%m-%d') days FROM fielddata fd\n" +
            "LEFT JOIN orchard_fielddstation of ON fd.fldstn_id=of.fldstn_id\n" +
            "LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "WHERE fd.fldstn_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(flddata_txtime)\n" +
            "AND fd.flddata_status='A'group by DATE_FORMAT(flddata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getWeekFm1(String equipmentId);
    @Select("SELECT flddata_humid,\n" +
            "         flddata_temp,\n" +
            "         flddata_sunlux,\n" +
            "         flddata_pa,\n" +
            "        flddata_txtime FROM fielddata WHERE fldstn_id=#{param1} ORDER BY flddata_txtime DESC LIMIT 0,1")
    List<Map<String, Object>> getNowFm1(String equipmentId);
    @Select(" SELECT\n" +
            "            AVG(fmbdata_windspd) fmbdata_windspd,\n" +
            "            AVG(fmbdata_rain) fmbdata_rain,\n" +
            "            AVG(fmbdata_winddir) fmbdata_winddir,\n" +
            "            AVG(fmbdata_soiltemp) fmbdata_soiltemp,\n" +
            "            AVG(fmbdata_soilmture) fmbdata_soilmture,\n" +
            "            DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d') days FROM fmb_data fd\n" +
            "            LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id\n" +
            "            LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "            LEFT JOIN orchard_garden og ON og.garden_address_id=oa.address_id\n" +
            "        WHERE fd.fmb_id=#{param1} AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(fmbdata_txtime)\n" +
            "        AND fd.fmbdata_status='A'\n" +
            "        group by DATE_FORMAT(fmbdata_txtime,'%Y-%m-%d')")
    List<Map<String, Object>> getWeekFm2(String equipmentId);

    @Select("\n" +
            "SELECT fmbdata_windspd,\n" +
            "            fmbdata_rain,\n" +
            "            fmbdata_winddir,\n" +
            "            fmbdata_soiltemp,\n" +
            "            fmbdata_soilmture,\n" +
            "            fmbdata_txtime FROM fmb_data fd WHERE fd.fmb_id=#{param1} ORDER BY fmbdata_txtime DESC LIMIT" +
            " 0,1")
    List<Map<String, Object>> getNowFm2(String equipmentId);
    @Select("SELECT flddata_humid,flddata_temp,flddata_sunlux,flddata_pa,flddata_txtime FROM fielddata  f\n" +
            "LEFT JOIN orchard_fielddstation of ON f.fldstn_id=of.fldstn_id LEFT JOIN orchard_ground_block ogb ON of.gb_id=ogb.gb_id\n" +
            "LEFT JOIN orchard_garden og ON og.garden_id=ogb.gb_garden_id WHERE og.garden_id =1 AND date_format(flddata_txtime,'%Y%m%d')=date_format(NOW(),'%Y%m%d') ORDER BY  \n" +
            "flddata_txtime DESC ")
    List<Map<String, Object>> getNowFm1ByGardenId(Integer id);
    @Select("SELECT fmbdata_windspd,fmbdata_rain,fmbdata_winddir,fmbdata_soiltemp,fmbdata_soilmture,fmbdata_txtime FROM fmb_data fd \n" +
            "LEFT JOIN orchard_fmb of ON fd.fmb_id=of.fmb_id LEFT JOIN orchard_ground_block ogb ON of.gb_id=ogb.gb_id\n" +
            "LEFT JOIN orchard_garden og ON og.garden_id=ogb.gb_garden_id\n" +
            "WHERE og.garden_id=1 AND date_format(fmbdata_txtime,'%Y%m%d')=date_format(NOW(),'%Y%m%d') ORDER BY fmbdata_txtime")
    List<Map<String, Object>> getNowFm2ByGardenId(Integer id);
}
