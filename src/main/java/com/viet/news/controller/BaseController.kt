package com.viet.news.controller


import com.viet.news.entity.user.TokenInfo
import com.viet.news.utils.TokenInfoHolder

/**
 * @author Junfeng Li
 * @package io.merculet.open.controller
 * @class BaseController
 * @email junfeng.li@magicwindow.cn
 * @date 2018/8/14 上午10:24
 * @description
 */
open class BaseController {

    /**
     * 获取当前登陆的用户信息
     * @return
     */
    fun getTokenInfo(): TokenInfo? = TokenInfoHolder.tokenInfo

}