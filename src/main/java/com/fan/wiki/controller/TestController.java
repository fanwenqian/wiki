package com.fan.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fan.wenqian
 * @date 2022-05-20 09:47
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }
}
