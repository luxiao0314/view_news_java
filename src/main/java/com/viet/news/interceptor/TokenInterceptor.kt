package com.viet.news.interceptor

import cn.magicwindow.score.common.util.TokenUtils.ERR_CODE_TOKEN_INVALID
import com.alibaba.fastjson.JSONObject
import com.viet.news.common.ResponseContent
import com.viet.news.entity.user.JwtInfoVo
import com.viet.news.entity.user.TokenInfo
import com.viet.news.service.JwtService
import com.viet.news.service.LoginService
import com.viet.news.utils.TokenInfoHolder
import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import org.apache.commons.lang3.StringUtils
import org.springframework.context.annotation.Configuration
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException
import java.io.UnsupportedEncodingException

/**
 * @author Junfeng Li
 * @package io.merculet.open.interceptor
 * @class TokenInterceptor
 * @email junfeng.li@magicwindow.cn
 * @date 2018/8/10 上午9:56
 * @description 解析token ,获取token中内容
 */
@Component
open class TokenInterceptor : HandlerInterceptorAdapter() {

    @Autowired
    private val jwtService: JwtService? = null
    @Autowired
    private val loginService: LoginService? = null

    @Throws(IOException::class)
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        request?.let { if (it.requestURI.contains("/v1/login")) return true }
        //clear tokenInfo
        TokenInfoHolder.clearTokenInfo()
        try {
            //使用user_token
            val authorization = request?.getHeader(TOKEN_ORG_HEADER)
            if (StringUtils.isNotBlank(authorization)) {
                setTokenInfo(authorization)
                return true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val genericResponse = ResponseContent.buildFail(ERR_CODE_TOKEN_INVALID, "token is invalid")
        response?.outputStream?.write(JSONObject.toJSONString(genericResponse).toByteArray())
        return false
    }

    @Throws(UnsupportedEncodingException::class)
    private fun setTokenInfo(authorization: String?) {
        jwtService?.verifyJwt(authorization)
        val jwtInfoVo = jwtService?.getJwtInfoFromToken(authorization)
        if (jwtInfoVo != null) {
            val tokenInfo = TokenInfo()
            val accessToken = loginService?.getToken(jwtInfoVo.userId)
            tokenInfo.accessToken = accessToken
            BeanUtils.copyProperties(jwtInfoVo, tokenInfo)
            TokenInfoHolder.tokenInfo = tokenInfo
        }
    }

    companion object {
        private val TOKEN_ORG_HEADER = "Authorization"
        private val ERR_CODE_TOKEN_INVALID = 403
    }

}