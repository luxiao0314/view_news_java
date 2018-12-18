package com.viet.news.repository

import com.viet.news.entity.BaseEntity
import com.viet.news.entity.ChannelList
import org.springframework.data.jpa.repository.JpaRepository

interface ChannelRepository : BaseEntityRepository<ChannelList>
