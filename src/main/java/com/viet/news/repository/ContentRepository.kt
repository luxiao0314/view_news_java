package com.viet.news.repository

import com.viet.news.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface ContentRepository : BaseEntityRepository<ContentBean> {
    fun findAllByChannelId(channelId: String?): List<ContentBean>
}
