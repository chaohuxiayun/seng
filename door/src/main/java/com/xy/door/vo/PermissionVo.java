package com.xy.door.vo;

import lombok.Data;

/**
 * @author xiayun
 * @version V1.0.0
 * @description PermissionVo
 * @date   2019/12/25 11:16
 */
@Data
public class PermissionVo {
    private Integer id;

    private String code;

    private String name;

    private String remark;

    private String url;

    private String icon;

    private Integer level;

    private Integer parentId;

    private String type;
}
