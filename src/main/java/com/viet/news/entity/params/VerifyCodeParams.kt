package com.viet.news.entity.params

/**
 * @Description
 * @Author sean
 * @Email xiao.lu@magicwindow.cn
 * @Date 11/09/2018 10:21 AM
 * @Version
 */
class VerifyCodeParams {
    var validation_code_type: String = ""
    var validation_code: String? = ""
    var zone_code: String? = "" // 国家代码 中国 86
    var phone_number: String? = ""
}