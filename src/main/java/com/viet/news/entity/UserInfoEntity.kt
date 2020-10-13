package com.viet.news.entity

import com.alibaba.fastjson.annotation.JSONField
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModelProperty
import lombok.Data
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Data
@Entity
@Table(name = "user")
class UserInfoEntity :BaseEntity() {
    @JSONField(name = "zone_code")
    @JsonProperty("zone_code")
    @Column(name = "zone_code")
    var zoneCode: Int? = 0

    @JSONField(name = "invite_code")
    @JsonProperty("invite_code")
    @Column(name = "invite_code")
    var inviteCode: String? = ""

    @JSONField(name = "follow_flag")
    @JsonProperty("follow_flag")
    @Column(name = "follow_flag")
    var followFlag: Boolean? = false

    @JSONField(name = "self_flag")
    @JsonProperty("self_flag")
    @Column(name = "self_flag")
    var selfFlag: Boolean? = false

    @JSONField(name = "is_bind")
    @JsonProperty("is_bind")
    @Column(name = "is_bind")
    var isBind: Boolean? = false

    @JSONField(name = "is_set_password")
    @JsonProperty("is_set_password")
    @Column(name = "is_set_password")
    var isSetPassword: Boolean? = false

    @JSONField(name = "fans_count")
    @JsonProperty("fans_count")
    @Column(name = "fans_count")
    var fansCount: Int? = 0

    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @Column(name = "user_id")
    var userId: Long?=0

    @JSONField(name = "role_id")
    @JsonProperty("role_id")
    @Column(name = "role_id")
    var roleId: String? = ""

    @JSONField(name = "follow_count")
    @JsonProperty("follow_count")
    @Column(name = "follow_count")
    var followCount: Int? = 0

    @JSONField(name = "nick_name")
    @JsonProperty("nick_name")
    @Column(name = "nick_name")
    var nickName: String? = ""

    @JSONField(name = "phone_number")
    @JsonProperty("phone_number")
    @Column(name = "phone_number")
    var phoneNumber: String? = ""

    @JSONField(name = "password")
    @JsonProperty("password")
    @Column(name = "password")
    var password: String? = ""

    @JSONField(name = "token")
    @JsonProperty("token")
    @Column(name = "token")
    var token: String? = ""

    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    @Column(name = "avatar")
    var avatar: String? = ""

    @Column(name = "expiry_time")
    @JSONField(name = "expiry_time")
    @JsonProperty("expiry_time")
    @ApiModelProperty(value = "accessToken过期时间")
    var expiryTime: Date? = null
}