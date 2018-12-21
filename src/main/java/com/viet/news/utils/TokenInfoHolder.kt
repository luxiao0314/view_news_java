package com.viet.news.utils


import com.viet.news.entity.user.TokenInfo

/**
 * @author Junfeng Li
 * @package io.merculet.management.util
 * @class SessionHolder
 * @email junfeng.li@magicwindow.cn
 * @date 2018/7/6 上午9:34
 * @description 保持session在ThreaLocal中
 */
object TokenInfoHolder {

    private val TOKEN_INFO_THREAD_LOCAL = InheritableThreadLocal<TokenInfo>()

    var tokenInfo: TokenInfo
        get() = TOKEN_INFO_THREAD_LOCAL.get()
        set(tokenInfo) = TOKEN_INFO_THREAD_LOCAL.set(tokenInfo)

    fun clearTokenInfo() {
        TOKEN_INFO_THREAD_LOCAL.remove()
    }

}