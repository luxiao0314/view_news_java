package com.viet.news.repository

import com.viet.news.entity.UserFollowEntity
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface UserFollowRepository : BaseEntityRepository<UserFollowEntity> {

    /**
     * nativeQuery:不加的话要用实体名去update,即如下
     * update viet_news user_follow set user_follow.deleted = 0 where user_follow.follow_user_id = 12"
     * 所谓本地查询，就是使用原生的sql语句（根据数据库的不同，在sql的语法或结构方面可能有所区别）进行查询数据库的操作。
     */
    @Modifying
    @Transactional
    @Query(value = "update user_follow set deleted = 1 where follow_user_id = 12", nativeQuery = true)
    fun follow(follow_user_id: Long?)

    @Modifying
    @Transactional  //Caused by: javax.persistence.TransactionRequiredException: Executing an update/delete query  需要加上事务
    @Query(value = "update user_follow set deleted = 0 where follow_user_id = 12", nativeQuery = true)
    fun cancelFollow(id: Long?)
}
