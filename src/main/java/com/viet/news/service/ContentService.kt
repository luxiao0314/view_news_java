package com.viet.news.service

import com.viet.news.entity.*
import com.viet.news.repository.ChannelRepository
import com.viet.news.repository.ContentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContentService {

    @Autowired
    var contentRepository: ContentRepository? = null

    fun getContent4Channel(channelId:String?): List<ContentBean>? {
        return contentRepository?.findAllByChannelId(channelId)
    }

//    fun getUser4Channel(channelId:String?): List<NewsListBean>? {
//        return contentRepository?.findAllByChannelId(channelId)
//    }
}
