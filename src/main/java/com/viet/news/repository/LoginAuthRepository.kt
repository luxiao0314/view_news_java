package com.viet.news.repository

import com.viet.news.entity.ContentBean
import com.viet.news.entity.LoginAuthResponse
import com.viet.news.entity.LoginRegisterResponse
import com.viet.news.entity.UserInfoEntity
import org.springframework.data.jpa.repository.Query

interface LoginAuthRepository : BaseEntityRepository<LoginAuthResponse> {
    fun findAllByUserId(userId: Long?): LoginAuthResponse?

    /**
     * 如果要使用参数中的值,可以用?1 表示第一个参数 ?2表示第二个
     */
    @Query(value = "SELECT oauth_token FROM user_oauth WHERE user_id = ?1", nativeQuery = true)
    fun getToken(user_id: Long?): String?
}
