package com.fan.wiki.service.impl;

import com.fan.wiki.entity.Ebook;
import com.fan.wiki.entity.EbookExample;
import com.fan.wiki.mapper.EbookMapper;
import com.fan.wiki.req.EbookReq;
import com.fan.wiki.resp.EbookResp;
import com.fan.wiki.service.IEbookService;
import com.fan.wiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookServiceImpl implements IEbookService {

    @Resource
    private EbookMapper ebookMapper;

    @Override
    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> list = ebookMapper.selectByExample(ebookExample);
        //        List<EbookResp> respList = new ArrayList<>();
        //        for (Ebook ebook : list) {
        //            EbookResp ebookResp = new EbookResp();
        //            BeanUtils.copyProperties(ebook,ebookResp);
        //            respList.add(ebookResp);
        //        }
        return CopyUtil.copyList(list, EbookResp.class);
    }
}
