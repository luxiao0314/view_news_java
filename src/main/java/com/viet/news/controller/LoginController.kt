package com.viet.news.controller

import com.viet.news.common.ResponseContent
import com.viet.news.entity.params.LoginParams
import com.viet.news.entity.params.VerifyCodeParams
import com.viet.news.service.LoginService
import com.viet.news.utils.SendCode
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/login")
class LoginController {

    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @Autowired
    var loginService: LoginService? = null

    var smsCode: String? = ""

    @PostMapping("/sendSms")
    fun sendSMS(@RequestBody param: VerifyCodeParams): ResponseContent<*>? {
        return try {
            val smsCodeResponse = SendCode.sendCode(param.phone_number)
            if (smsCodeResponse?.code == "200") {
                smsCode = smsCodeResponse.obj
                ResponseContent.buildSuccess("success", null)
            } else {
                logger.error("error", smsCodeResponse?.msg)
                ResponseContent.buildFail("出错啦\n" + smsCodeResponse?.msg)
            }
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    @PostMapping("/login")
    fun loginBySms(@RequestBody param: LoginParams): ResponseContent<*>? {
        return try {
            if (param.validation_code == smsCode) {
                ResponseContent.buildSuccess("success", loginService?.login(param.phone_number))
            } else {
                logger.error("error", "验证码输入有误")
                ResponseContent.buildFail("验证码输入有误")
            }
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    @GetMapping("/getToken")
    fun getToken(@RequestParam(value = "user_id") user_id: String): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", loginService?.getToken(user_id.toLong()))
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }
}