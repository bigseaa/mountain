package com.sea.ums.controller;

import com.sea.common.entity.Result;
import com.sea.ums.domain.Role;
import com.sea.ums.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/queryRoleById")
    public Result queryRoleById(@RequestParam String id) {
        Role role = roleService.queryRoleById(id);
        Result result = Result.SUCCESS();
        result.setData(role);
        return result;
    }
}
