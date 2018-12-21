package com.viet.news.config

import com.viet.news.interceptor.TokenInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
open class InterceptorConfig : WebMvcConfigurerAdapter() {
    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry?.addInterceptor(TokenInterceptor())
    }
}