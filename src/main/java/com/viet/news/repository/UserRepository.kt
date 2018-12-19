package com.viet.news.repository

import com.viet.news.entity.ContentBean
import com.viet.news.entity.UserInfoEntity

interface UserRepository : BaseEntityRepository<UserInfoEntity> {
    fun findUserById(id: Long?): UserInfoEntity
}
