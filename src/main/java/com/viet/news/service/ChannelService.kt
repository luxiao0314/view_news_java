package com.viet.news.service

import com.viet.news.entity.ChannelList
import com.viet.news.repository.ChannelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChannelService {

    @Autowired
    var channelRepository: ChannelRepository? = null

    fun allList(): List<ChannelList> {
        return channelRepository!!.findAll()
    }
}
