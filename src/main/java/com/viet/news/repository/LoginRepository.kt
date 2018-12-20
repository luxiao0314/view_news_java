package com.viet.news.repository

import com.viet.news.entity.ContentBean
import com.viet.news.entity.LoginRegisterResponse
import com.viet.news.entity.UserInfoEntity

interface LoginRepository : BaseEntityRepository<LoginRegisterResponse> {
    fun findAllByPhoneNumber(phoneNumber: String?): LoginRegisterResponse?
}
