package com.viet.news.controller

import com.viet.news.common.ResponseContent
import com.viet.news.config.LoginEnum
import com.viet.news.entity.user.JwtInfoVo
import com.viet.news.entity.UserInfoEntity
import com.viet.news.entity.params.LoginParams
import com.viet.news.entity.params.RegisterParams
import com.viet.news.entity.params.VerifyCodeParams
import com.viet.news.service.JwtService
import com.viet.news.service.LoginService
import com.viet.news.utils.SendCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/login")
class LoginController : BaseController() {

    @Autowired
    var loginService: LoginService? = null

    @Autowired
    var jwtService: JwtService? = null

    var smsCode: String? = ""

    @PostMapping("/sendSms")
    fun sendSMS(@RequestBody param: VerifyCodeParams): ResponseContent<*>? {
        return try {
            val smsCodeResponse = SendCode.sendCode(param.phone_number)
            if (smsCodeResponse?.code == "200") {
                smsCode = smsCodeResponse.obj
                ResponseContent.buildSuccess("success", null)
            } else {
                ResponseContent.buildFail("出错啦\n" + smsCodeResponse?.msg)
            }
        } catch (e: Exception) {
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody param: LoginParams): ResponseContent<*>? {
        return try {
            when (param.login_type) {
                LoginEnum.VALIDATION_CODE.name -> verifyCode(param)
                LoginEnum.PASSWORD.name -> verifyPWD(param)
                else -> ResponseContent.buildFail("出错啦\n")
            }
        } catch (e: Exception) {
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody param: RegisterParams): ResponseContent<*>? {
        return try {
            if (param.verify_code == smsCode) {
                var userInfo = loginService?.getUserInfo(param.phone_number)
                if (userInfo == null) {
                    userInfo = loginService?.getOrCreateByOpenUser(param.phone_number)
                    userInfo?.token = generateCommunityToken(userInfo)
                    ResponseContent.buildSuccess("success", userInfo)
                } else {
                    ResponseContent.buildFail("出错啦\n" + "手机号已注册")
                }
            } else {
                ResponseContent.buildFail("出错啦\n" + "验证码输入有误")
            }
        } catch (e: Exception) {
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    /**
     * 校验验证码
     */
    private fun verifyCode(param: LoginParams): ResponseContent<*>? {
        return if (param.validation_code == smsCode) {
            var userInfo = loginService?.getUserInfo(param.phone_number)
            if (userInfo == null) {
                userInfo = loginService?.getOrCreateByOpenUser(param.phone_number)
                userInfo?.token = generateCommunityToken(userInfo)
                ResponseContent.buildSuccess("success", userInfo)
            } else {
                userInfo.token = loginService?.getToken(userInfo.id)
            }
            ResponseContent.buildSuccess("success", userInfo)
        } else {
            ResponseContent.buildFail("验证码输入有误")
        }
    }

    /**
     * 校验密码
     */
    private fun verifyPWD(param: LoginParams): ResponseContent<*>? {
        val userInfo = loginService?.getUserInfo(param.phone_number)
        return if (userInfo == null) {
            ResponseContent.buildFail("尚未设置过密码")
        } else {
            userInfo.token = loginService?.getToken(userInfo.id)
            if (param.password == userInfo.password) {
                ResponseContent.buildSuccess("success", userInfo)
            } else {
                ResponseContent.buildFail("密码输入有误")
            }
        }
    }

    @GetMapping("/getToken")
    fun getToken(@RequestParam(value = "user_id") user_id: String): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", loginService?.getToken(user_id.toLong()))
        } catch (e: Exception) {
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    /**
     * 根据communityUser创建token
     *
     * @param communityUser
     * @return
     */
    private fun generateCommunityToken(communityUser: UserInfoEntity?): String? {
        val jwtInfoVo = JwtInfoVo()
        jwtInfoVo.phoneNumber = communityUser?.phoneNumber
        jwtInfoVo.userId = communityUser?.userId
        return jwtService?.createJwt(jwtInfoVo)
    }
}