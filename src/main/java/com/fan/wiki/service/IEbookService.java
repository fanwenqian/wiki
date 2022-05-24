package com.fan.wiki.service;

import com.fan.wiki.entity.Ebook;
import com.fan.wiki.req.EbookReq;

import java.util.List;

public interface IEbookService {

    List<Ebook> list(EbookReq req);
}
