package com.sea.demo.dao;

import com.sea.demo.domain.DemoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoDao extends JpaRepository<DemoDomain, Long>, JpaSpecificationExecutor<DemoDomain> {

}
