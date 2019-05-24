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
 * 创建时间 2019/4/28
 */
@Mapper
public interface GardenMapper {
    Map<String, Object> getGardenDetail(Integer id);
    @Select("SELECT \n" +
            "og.garden_id AS  id\n" +
            "FROM orchard_garden og \n" +
            "LEFT JOIN orchard_user ou ON og.garden_user_id=ou.user_id \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id\n" +
            "LEFT JOIN orchard_ground_block ogb ON og.garden_id=ogb.gb_garden_id\n" +
            "LEFT JOIN orchard_plant op ON ogb.gb_id=op.plant_gb_id\n" +
            "LEFT JOIN orchard_crop oc ON op.plant_crop_id=oc.crop_id\n" +
            "WHERE og.garden_approve_state='PS'\n" +
            "ORDER BY op.plant_area DESC LIMIT 0,1 ")
    Integer getFristId();

     List<Map<String, Object>> getWindSpeeds(Integer id);

    List<Map<String, Object>> getFm1Data(Integer id);

    List<Map<String, Object>> getCropAreaTime(@Param("Id") Integer id);

    @Select("SELECT COUNT(1)AS count, date_format(farm_start_time,'%m') AS time FROM orchard_farm_work  \n" +
            "WHERE farm_type=1 AND farm_gd_id=#{param1} GROUP BY date_format(farm_start_time,'%Y-%m')")
    List<Map<String, Object>> getFertilizeCount(Integer id);

    @Select("SELECT COUNT(1)AS count, date_format(farm_start_time,'%m') AS time FROM orchard_farm_work  \n" +
            "WHERE farm_type=2 AND farm_gd_id=#{param1} GROUP BY date_format(farm_start_time,'%Y-%m')")
    List<Map<String, Object>> getPlantPro(Integer id);
    @Select("SELECT \n" +
            "ogb.gb_name AS gbName,\n" +
            "oa.address_gislatd AS gislatd,\n" +
            "oa.address_gislong AS gislong,\n" +
            "camera_id AS cameraId,\n" +
            "camera_name AS cameraName,\n" +
            "camera_hls_url AS url,\n" +
            "camera_rtmp_url AS hurl\n" +
            "FROM orchard_camera oc\n" +
            "LEFT JOIN orchard_ground_block ogb ON oc.gb_id=ogb.gb_id\n" +
            "LEFT JOIN orchard_address oa ON oc.address_id=oa.address_id\n" +
            "WHERE garden_id=#{param1} GROUP BY camera_sno\n")
    List<Map<String, Object>> getCameras(Integer id);

    @Select("SELECT og.garden_id AS gardenId,og.garden_name AS gardenName, " +
            "oa.address_gislatd AS gislatd,oa.address_gislong AS gislong FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id \n" +
            "WHERE address_prov like CONCAT('%',#{param1},'%')")
    List<Map<String, Object>> getGardenByProv(String address);

    @Select("SELECT og.garden_id AS gardenId,og.garden_name AS gardenName " +
            ", oa.address_gislatd AS gislatd,oa.address_gislong AS gislong FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id \n" +
            "WHERE oa.address_city like CONCAT('%',#{param1},'%')")
    List<Map<String, Object>> getGardenByCity(String address);

    @Select("SELECT og.garden_id AS gardenId,og.garden_name AS gardenName " +
            " oa.address_gislatd AS gislatd,oa.address_gislong AS gislong FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id \n" +
            "WHERE oa.address_county like CONCAT('%',#{param1},'%')")
    List<Map<String, Object>> getGardenByCounty(String address);

    @Select("SELECT og.garden_id AS gardenId,og.garden_name AS gardenName " +
            " oa.address_gislatd AS gislatd,oa.address_gislong AS gislong FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id \n" +
            "WHERE oa.address_town like CONCAT('%',#{param1},'%')")
    List<Map<String, Object>> getGardenByTown(String address);

    @Select("SELECT og.garden_id AS gardenId,og.garden_name AS gardenName " +
            "oa.address_gislatd AS gislatd,oa.address_gislong AS gislong FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id \n" +
            "WHERE oa.address_village like CONCAT('%',#{param1},'%')")
    List<Map<String, Object>> getGardenByVillage(String address);


    @Select("SELECT camera_id AS cameraId, camera_name AS cameraName,camera_hls_url AS url FROM orchard_camera oc " +
            "WHERE oc.camera_id=#{param1}")
    Map<String, String> getVideoUrl(String cameraId);

    @Select("SELECT ogb.gb_name AS gbName,address_gislong AS gislong,  address_gislatd AS gislatd FROM orchard_garden" +
            " og\n" +
            "LEFT JOIN orchard_ground_block ogb ON og.garden_id=ogb.gb_garden_id \n" +
            "LEFT JOIN orchard_address oa ON ogb.address_id=oa.address_id\n" +
            "WHERE og.garden_id=#{param1}")
    List<Map<String, Object>> getMassif(Integer id);
    @Select("SELECT og.garden_id AS gardenId,\n" +
            "og.garden_name AS gardenName,\n" +
            "oa.address_gislatd AS islatd,\n" +
            "oa.address_gislong AS islong FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id WHERE og.garden_name LIKE CONCAT('%',#{param1},'%')")
    List<Map<String,Object>> getgardenAddress(String gardenName);
    @Select("SELECT garden_name AS gardenName,\n" +
            "address_gislong AS gislong,\n" +
            "address_gislatd AS gislatd FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id\n" +
            "WHERE garden_address_id IN \n" +
            "(SELECT address_id FROM orchard_garden og \n" +
            "LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id \n" +
            "WHERE og.garden_id=#{param1})")
    List<Map<String,String>> getGardens(Integer id);

    @Select("SELECT a.gradenId AS gradenId, gardenName,(fm1count+fm2count) AS `count`, gitlatd,gislong FROM\n" +
            "(SELECT og.garden_name AS gardenName,\n" +
            "            COUNT(ofn.fldstn_id) AS fm1count,\n" +
            "            oa.address_gislatd AS gitlatd,\n" +
            "            oa.address_gislong AS gislong,\n" +
            "            og.garden_id AS gradenId\n" +
            "            FROM  orchard_garden og \n" +
            "            LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id\n" +
            "\t\t\t\t\t\tLEFT JOIN orchard_fielddstation ofn on oa.address_id=ofn.address_id\n" +
            "             GROUP BY og.garden_id) a\n" +
            "\t\t\t\t\t\t LEFT JOIN\n" +
            " (SELECT  COUNT(of.fmb_id) AS fm2count,\n" +
            "\t\t\t\t\t\tog.garden_id AS gardenId\n" +
            "            FROM  orchard_garden og \n" +
            "            LEFT JOIN orchard_address oa ON og.garden_address_id=oa.address_id\n" +
            "\t\t\t\t\t\tLEFT JOIN orchard_fmb of on oa.address_id=of.address_id\n" +
            "             GROUP BY og.garden_id) b ON a.gradenId=b.gardenId")
    List<Map<String, String>> getGardenList();
    @Select("SELECT \n" +
            "of.fmb_id,\n" +
            "of.fmb_name AS fmbName,\n" +
            "address_gislong AS gislong,\n" +
            "address_gislatd AS gislatd,\n" +
            "ogb.gb_name AS gbName,\n" +
            "'FM2' AS type\n" +
            "FROM orchard_fmb of \n" +
            "LEFT JOIN orchard_address oa ON of.address_id=oa.address_id\n" +
            "LEFT JOIN orchard_ground_block ogb ON ogb.address_id=oa.address_id\n" +
            "WHERE ogb.gb_id=#{param1}\n" +
            "UNION ALL\n" +
            "SELECT \n" +
            "of.fldstn_id,\n" +
            "of.fldstn_name AS fldstn_name,\n" +
            "address_gislong AS gislong,\n" +
            "address_gislatd AS gislatd,\n" +
            "ogb.gb_name AS gbName,\n" +
            "'FM1' AS type\n" +
            "FROM orchard_fielddstation of \n" +
            "LEFT JOIN orchard_address oa ON of.address_id=oa.address_id \n" +
            "LEFT JOIN orchard_ground_block ogb ON ogb.address_id=oa.address_id\n" +
            "WHERE ogb.gb_id=#{param1}")
    List<Map<String, Object>> getEquipmentAddress(Integer id);
}
