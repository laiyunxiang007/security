package com.yf.garden.bs.dao;

import com.yf.garden.bs.login.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/21
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM orchard_user WHERE user_account=#{param1} AND user_role IN(0,3)")
    User findUserByName(String username);

    @Select("SELECT role_name FROM orchard_user ou INNER  JOIN orchard_user_role our ON ou.user_id=our.ur_user_id\n" +
            "INNER JOIN orchard_role oro ON our.ur_role_id=oro.role_id WHERE user_id=#{param1}")
    String findRoleById(Long user_id);
}
