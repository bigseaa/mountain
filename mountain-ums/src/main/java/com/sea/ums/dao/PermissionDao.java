package com.sea.ums.dao;

import com.sea.ums.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissionDao extends JpaRepository<Permission,String>, JpaSpecificationExecutor<Permission> {
}
