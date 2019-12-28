package com.sea.demo.service.impl;

import com.sea.demo.dao.DemoDao;
import com.sea.demo.domain.DemoDomain;
import com.sea.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;

    @Override
    public List<DemoDomain> getDemoDomainList() {
        List<DemoDomain> testDomainList = new ArrayList<>();
        testDomainList.add(new DemoDomain(1, "张三"));
        testDomainList.add(new DemoDomain(2, "李四"));
        testDomainList.add(new DemoDomain(3, "王五"));
        testDomainList.add(new DemoDomain(4, "赵柳"));
        testDomainList.add(new DemoDomain(5, "陈琦"));
        return testDomainList;
    }

    @Override
    public DemoDomain getDemoDomainById(Long id) {
        DemoDomain demoDomain = demoDao.findById(1L).get();
        return demoDomain;
    }
}
