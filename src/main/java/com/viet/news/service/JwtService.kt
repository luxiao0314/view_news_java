package com.viet.news.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.viet.news.entity.user.JwtInfoVo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import javax.servlet.ServletRequest
import javax.servlet.http.HttpServletRequest
import java.io.UnsupportedEncodingException
import java.util.*

/**
 * @author Junfeng Li
 * @package io.merculet.open.service
 * @class JwtService
 * @email junfeng.li@magicwindow.cn
 * @date 2018/8/9 上午10:51
 * @description jwttokenService
 */
@Component
class JwtService {

    private val logger = LoggerFactory.getLogger(JwtService::class.java)

    @Value("\${jwt.sign_key}")
    private val signKey: String? = null

    @Value("\${jwt.access_token_expire_time}")
    private val expireTime: Long? = null


    /**
     * 校验token是否正确
     * @param token
     * @return
     */
    @Throws(UnsupportedEncodingException::class)
    fun verifyJwt(token: String?): Boolean {
        val algorithm = Algorithm.HMAC256(signKey)
        val verifier = JWT.require(algorithm)
                .build()
        try {
            verifier.verify(token)
        } catch (e: TokenExpiredException) {
            return true
        }

        return true
    }

    /**
     * 校验token是否正确,检验sign和过期时间,token为空，解密出错或是过期都返回false
     * @param token
     * @return
     */
    fun verifyJwtV2(token: String?): Boolean {
        if (token.isNullOrBlank()) {
            return false
        }
        return try {
            val algorithm = Algorithm.HMAC256(signKey)
            val verifier = JWT.require(algorithm)
                    .build()
            verifier.verify(token)
            true
        } catch (e: Exception) {
            logger.error(" error occur in verify JwtToken :{}", token, e)
            false
        }

    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    fun getValueByParams(token: String, key: String): String? {
        try {
            val jwt = JWT.decode(token)
            val claims = jwt.claims
            if (claims != null && claims.isNotEmpty() && claims.containsKey(key)) {
                return claims[key]?.asString()
            }
        } catch (e: JWTDecodeException) {
            logger.error("get value from jwt token error with token : {} and key : {}", token, key)
        }

        return null
    }

    fun getAccountIdFromToken(request: ServletRequest): Long? {
        val httpServletRequest = request as HttpServletRequest
        val authorization = httpServletRequest.getHeader("Authorization")

        val accountId = this.getValueByParams(authorization, "account_id")

        return java.lang.Long.valueOf(accountId)
    }

    /**
     * 生成jwt token，放的有openId
     * @param jwtInfoVo
     * @return
     */
    fun createJwt(jwtInfoVo: JwtInfoVo): String? {
        return try {
            JWT.create().withIssuer("viet_news")
                    .withSubject("news")
                    .withClaim("userId", jwtInfoVo.userId)
                    .withClaim("phoneNumber", jwtInfoVo.phoneNumber)
                    .withIssuedAt(Date())
                    .withExpiresAt(Date(System.currentTimeMillis() + expireTime!! * 1000L))
                    .sign(Algorithm.HMAC256(signKey))
        } catch (e: UnsupportedEncodingException) {
            logger.error("create jwt token error {}", jwtInfoVo)
            throw Exception(e)
        }
    }

    /**
     * 从token中获取jwtInfo
     * @param token
     * @return
     */
    fun getJwtInfoFromToken(token: String?): JwtInfoVo? {
        try {
            val jwt = JWT.decode(token)
            val claims = jwt.claims
            if (claims != null && claims.isNotEmpty()) {
                val jwtInfo = JwtInfoVo()
                if (claims["userId"] != null) {
                    jwtInfo.userId = claims["userId"]?.asLong()
                }
                if (claims["phoneNumber"] != null) {
                    jwtInfo.phoneNumber = claims["phoneNumber"]?.asString()
                }
                return jwtInfo
            }
            return null
        } catch (e: JWTDecodeException) {
            logger.error("get value from jwt token error with token : {}  ", token)
            return null
        }
    }
}