package com.viet.news.service;

import com.viet.news.entity.ChannelList;
import com.viet.news.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    public ChannelRepository channelRepository;

    public List<ChannelList> allList() {
        return channelRepository.findAll();
    }
}
