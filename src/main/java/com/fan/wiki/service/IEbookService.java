package com.fan.wiki.service;

import com.fan.wiki.entity.Ebook;
import com.fan.wiki.req.EbookReq;
import com.fan.wiki.resp.EbookResp;

import java.util.List;

public interface IEbookService {

    List<EbookResp> list(EbookReq req);
}
