package com.yf.garden.bs.login.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/22
 */
@Component
@Data
public class User {
    private Long user_id;
    private String user_account;
    private String user_password;
    private String user_real_name;
    private Integer user_role;
    private String user_mobile;
    private Long user_addr_id;
    private Integer user_status;
    private String user_head;
    private Long user_create_by;
    private Date user_cret_time;
    private Date user_update_time;
    private Long user_update_by;
    private Integer user_delete_flag;
    private Date user_join_date;
    private String user_wchat_open_id;
    private Integer user_type;
    private String user_wchart_nick_name;
    private String user_email;
    private Long user_garden_id;
    private Long employee_id;
}
