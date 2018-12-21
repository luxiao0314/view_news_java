package com.viet.news.config

import cn.magicwindow.score.common.filter.TokenFilter
import com.viet.news.interceptor.CorsInterceptor
import com.viet.news.interceptor.TokenInterceptor
import io.grpc.ManagedChannel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

import java.util.Collections

@Configuration
open class WebAppConfig : WebMvcConfigurer {

    /**
     * 自己定义的拦截器类
     * @return
     */
    @Bean
    open fun tokenInterceptor(): TokenInterceptor {
        return TokenInterceptor()
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(tokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/v1/login/login", "/v1/login/register")
    }
}