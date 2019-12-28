package com.sea.ums.service.impl;

import com.sea.ums.dao.PermissionDao;
import com.sea.ums.domain.Permission;
import com.sea.ums.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission queryPermissionById(String id) {
        return permissionDao.findById(id).get();
    }
}
