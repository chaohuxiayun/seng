package com.xy.permission.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author xiayun
 * @version V1.0.0
 * @description UserVo
 * @date   2019/12/11 11:35
 */
@Data
public class UserVo {

    private Integer id;

    private String name;

    private String loginName;

    private String tel;

    private String address;

    private String remark;

    private Integer loginCount;

    private Date firstLoginTime;

    private Date lastLoginTime;

    private String isOnline;

}
