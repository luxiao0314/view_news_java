package com.viet.news.entity.params

import java.io.Serializable

/**
 * @Description
 * @Author sean
 * @Email xiao.lu@magicwindow.cn
 * @Date 2018/9/10 下午1:41
 * @Version
 */
class LoginParams : Serializable {
    var phone_number: String? = ""
    var validation_code: String? = ""
    var password: String? = ""
    var oauth_expires: String? = ""
    var oauth_token: String? = ""
    var oauth_user_id: String? = ""
    var invite_code: String? = ""
    var device_id: String? = ""
    var os_type: String? = ""
    var login_type: String? = ""
}