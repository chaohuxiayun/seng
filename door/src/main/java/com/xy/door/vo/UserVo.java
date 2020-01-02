package com.xy.door.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiayun
 * @version V1.0.0
 * @description UserVo
 * @date   2019/12/11 16:42
 */
@Data
public class UserVo implements Serializable {

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
