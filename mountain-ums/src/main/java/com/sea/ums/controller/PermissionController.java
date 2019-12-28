package com.sea.ums.controller;

import com.sea.common.entity.Result;
import com.sea.ums.domain.Permission;
import com.sea.ums.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/queryPermissionById")
    public Result queryPermissionById(@RequestParam String id) {
        Permission permission = permissionService.queryPermissionById(id);
        Result result = Result.SUCCESS();
        result.setData(permission);
        return result;
    }
}
