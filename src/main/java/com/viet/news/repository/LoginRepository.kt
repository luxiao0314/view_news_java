package com.viet.news.repository

import com.viet.news.entity.UserInfoEntity

interface LoginRepository : BaseEntityRepository<UserInfoEntity> {
    fun findAllByPhoneNumber(phoneNumber: String?): UserInfoEntity?
}
