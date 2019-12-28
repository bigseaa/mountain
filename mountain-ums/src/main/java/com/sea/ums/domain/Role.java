package com.sea.ums.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 是否启用1.启用  0.禁用
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

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private Set<Permission> permissions = new HashSet<>();
}
