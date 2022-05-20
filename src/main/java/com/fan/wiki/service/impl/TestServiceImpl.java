package com.fan.wiki.service.impl;

import com.fan.wiki.entity.Test;
import com.fan.wiki.mapper.TestMapper;
import com.fan.wiki.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.list();
    }
}
