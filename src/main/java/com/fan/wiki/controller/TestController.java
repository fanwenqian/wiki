package com.fan.wiki.controller;

import com.fan.wiki.entity.Test;
import com.fan.wiki.service.ITestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fan.wenqian
 * @date 2022-05-20 09:47
 */
@RestController
public class TestController {

    @Resource
    private ITestService testService;

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("list")
    public List<Test> list() {
        return testService.list();
    }
}
