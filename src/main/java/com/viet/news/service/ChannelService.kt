package com.viet.news.service

import com.viet.news.entity.ChannelAllList
import com.viet.news.entity.ChannelList
import com.viet.news.repository.ChannelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChannelService {

    @Autowired
    var channelRepository: ChannelRepository? = null

    fun list(): List<ChannelList>? = channelRepository?.findAll()

    fun allList(): ChannelAllList {
        val channelAllList = ChannelAllList()
        channelRepository?.findAll()?.forEach {
            if (it.default_channel!!) {
                channelAllList.followChannelList.add(it)
            } else {
                channelAllList.unFollowChannelList.add(it)
            }
        }
        return channelAllList
    }
}
