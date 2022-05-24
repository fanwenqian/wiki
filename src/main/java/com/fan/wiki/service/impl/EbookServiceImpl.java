package com.fan.wiki.service.impl;

import com.fan.wiki.entity.Ebook;
import com.fan.wiki.mapper.EbookMapper;
import com.fan.wiki.service.IEbookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookServiceImpl implements IEbookService {

    @Resource
    private EbookMapper ebookMapper;

    @Override
    public List<Ebook> list() {
        return ebookMapper.selectByExample(null);
    }
}
