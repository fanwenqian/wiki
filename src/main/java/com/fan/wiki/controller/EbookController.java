package com.fan.wiki.controller;

import com.fan.wiki.entity.Ebook;
import com.fan.wiki.resp.CommonResp;
import com.fan.wiki.service.IEbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fan.wenqian
 * @date 2022-05-24 14:07
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private IEbookService ebookService;

    @GetMapping("list")
    public CommonResp<List<Ebook>> list(String name) {
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> list = ebookService.list(name);
        resp.setContent(list);
        return resp;
    }
}
