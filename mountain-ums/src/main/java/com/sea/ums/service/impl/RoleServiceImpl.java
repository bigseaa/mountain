package com.sea.ums.service.impl;

import com.sea.ums.dao.RoleDao;
import com.sea.ums.domain.Role;
import com.sea.ums.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role queryRoleById(String id) {
        return roleDao.findById(id).get();
    }
}
