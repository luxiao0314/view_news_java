package com.viet.news.entity

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Table

@Data
@Entity
@Table(name = "user")
class UserInfoEntity :BaseEntity() {
    var zone_code: Int = 0
    var phone_number: String? = ""
    var nick_name: String? = ""
    var avatar: String? = ""
    var invite_code: String? = ""
    var follow_flag: Boolean = false
    var self_flag: Boolean = false
    var fans_count: Int = 0
    var follow_count: Int = 0
    var is_bind: Boolean = false
    var is_set_password: Boolean = false
}