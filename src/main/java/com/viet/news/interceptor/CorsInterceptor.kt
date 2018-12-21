package com.viet.news.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author zhou liming
 * @package io.merculet.auth.interceptor
 * @date 2018/11/15 11:17
 * @description
 */

@Configuration
open class CorsInterceptor : HandlerInterceptorAdapter() {

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        response?.setHeader("Access-Control-Allow-Origin", "*")
        response?.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
        response?.setHeader("Access-Control-Allow-Credentials", "true")
        response?.setHeader("Access-Control-Max-Age", "3600")
        response?.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, locale, Accept-Language")
        return true
    }
}
