package com.viet.news.entity.params

import java.io.Serializable

/**
 * @Description
 * @Author sean
 * @Email xiao.lu@magicwindow.cn
 * @Date 11/09/2018 10:21 AM
 * @Version
 */
class RegisterParams : Serializable {
    var device_id: String? = ""
    var os_type: String? =  ""
    var invite_code: String? = ""
    var oauth_type: String? = ""
    var oauth_user_id: String? = ""
    var password: String? = ""
    var phone_number: String? = ""
    var verify_code: String? = ""
}