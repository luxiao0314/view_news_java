package com.viet.news.service

import com.viet.news.entity.ContentBean
import com.viet.news.repository.ContentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContentService {

    @Autowired
    var contentRepository: ContentRepository? = null

    fun getContent4Channel(id:String?): List<ContentBean>? {
        return contentRepository?.findAll()
    }

//    fun getUser4Channel(channelId:String?): List<NewsListBean>? {
//        return contentRepository?.findAllByChannelId(channelId)
//    }
}
