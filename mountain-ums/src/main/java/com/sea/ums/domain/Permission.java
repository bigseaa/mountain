package com.sea.ums.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "permission")
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 权限名
     */
    private String name;
    /**
     * 权限编码
     */
    private String code;
    /**
     * 是否启用 0.禁用 1.启用
     */
    private Integer isAble;
    /**
     * 说明
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
