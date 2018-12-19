package com.viet.news.service

import com.viet.news.controller.ContentController
import com.viet.news.entity.UserFollowEntity
import com.viet.news.entity.UserInfoEntity
import com.viet.news.repository.UserFollowRepository
import com.viet.news.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    var userRepository: UserRepository? = null

    @Autowired
    var userFollowRepository: UserFollowRepository? = null

    fun getUserInfo(id: Long?): UserInfoEntity? {
        return userRepository?.findUserById(id)
    }

    //JPA更新字段的原理大概是先执行select语句判断是否数据已存在，若存在则执行updata语句进行更新操作。那JPA是如何对save()操作进行分辨的呢？答案是主键是否被赋值
    fun follow(follow_user_id: Long?) {
        userFollowRepository?.follow(follow_user_id)
    }

    fun cancelFollow(follow_user_id: Long?) {
        userFollowRepository?.cancelFollow(follow_user_id)
    }

    fun followList(user_id: Long?): List<UserInfoEntity>? {
        val list = arrayListOf<UserInfoEntity>()
        userFollowRepository?.findFollowUserIdByUserId(user_id)?.forEach {
            userRepository?.findUserById(it.followUserId)?.let { it1 -> list.add(it1) }
        }
        return list
    }

    fun fansList(user_id: Long?): List<UserInfoEntity>? {
        val list = arrayListOf<UserInfoEntity>()
        userFollowRepository?.findFollowUserIdByFollowUserId(user_id)?.forEach {
            userRepository?.findUserById(it.followUserId)?.let { it1 -> list.add(it1) }
        }
        return list
    }

}
