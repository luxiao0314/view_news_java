package com.viet.news.service

import com.viet.news.entity.ContentBean
import com.viet.news.entity.UserInfoEntity
import com.viet.news.repository.ContentRepository
import com.viet.news.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    var userRepository: UserRepository? = null

    fun getUserInfo(id:Long?): UserInfoEntity? {
        return userRepository?.findUserById(id)
    }

}
