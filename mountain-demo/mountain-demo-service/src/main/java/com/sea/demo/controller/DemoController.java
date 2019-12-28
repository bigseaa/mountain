package com.sea.demo.controller;

import com.sea.common.entity.PageResult;
import com.sea.common.entity.Result;
import com.sea.demo.domain.DemoDomain;
import com.sea.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/getDemoDomain")
    public Result getDemoDomain() {
        List<DemoDomain> demoDomainList = demoService.getDemoDomainList();
        PageResult<DemoDomain> pageResult = new PageResult<>();
        pageResult.setRows(demoDomainList);
        pageResult.setTotal(demoDomainList.size());
        Result result = Result.SUCCESS();
        result.setData(pageResult);
        return result;
    }

    @GetMapping("/getDemoById")
    public Result getDemoById() {
        DemoDomain demoDomain = demoService.getDemoDomainById(1L);
        Result result = Result.SUCCESS();
        result.setData(demoDomain);
        return result;
    }
}
