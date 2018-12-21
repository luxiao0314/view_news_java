package com.viet.news.entity.user

import lombok.Data

/**
 * @author Junfeng Li
 * @package io.merculet.community.bean
 * @class TokenInfo
 * @email junfeng.li@magicwindow.cn
 * @date 2018/9/7 上午9:47
 * @description
 */
@Data
class TokenInfo {

    /**
     * 开放平台的accountId 或是openID
     */
    var openId: String? = null

    /**
     * 社群项目用户id
     */
    var communityUserId: Long? = null

    /**
     * 调用开放平台的accessToken
     */
    var accessToken: String? = null

}