package com.viet.news.controller;

import com.viet.news.entity.ChannelList;
import com.viet.news.repository.ChannelRepository;
import com.viet.news.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/channel")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @GetMapping("/allList")
    @ResponseBody
    public List<ChannelList> allList() {
        return channelService.allList();
    }
}
