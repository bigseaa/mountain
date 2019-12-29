package com.sea.ums.vo;

import com.sea.ums.domain.Permission;
import com.sea.ums.domain.Role;
import com.sea.ums.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class ProfileResult {
    private String mobile;
    private String username;
    private Map<String, Object> roles;

    Set<String> permissionCodes = new HashSet<>();
    public ProfileResult(User user) {
        roles = new HashMap<>();
        this.mobile = user.getMobile();
        this.username = user.getUsername();
        Set<Role> roles = user.getRoles();
        for(Role role : roles) {
            Set<Permission> permissions = role.getPermissions();
            for(Permission permission : permissions) {
                String code = permission.getCode();
                permissionCodes.add(code);
            }
        }
        this.roles.put("permissionCodes", permissionCodes);
    }
}
