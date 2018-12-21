package com.viet.news.entity.user

import lombok.Data

/**
 * @author Junfeng Li
 * @package io.merculet.open.vo
 * @class JwtInfoVo
 * @email junfeng.li@magicwindow.cn
 * @date 2018/8/9 上午11:08
 * @description 用于生成jwttoken的bean
 */
@Data
class JwtInfoVo() {

    /**
     * 过期时间
     */
    var expires: Long? = null
    /**
     * 开放平台用户id
     */
    var userId: Long? = null

    var phoneNumber: String? = null

}