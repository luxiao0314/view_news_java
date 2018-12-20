package com.viet.news.entity

import com.alibaba.fastjson.annotation.JSONField
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Data
@Entity
@Table(name = "user")
class LoginRegisterResponse : BaseEntity() {
    @JSONField(name = "fans_count")
    @JsonProperty("fans_count")
    @Column(name = "fans_count")
    var fansCount: Int = 0

    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @Column(name = "user_id")
    var userId: String? = ""

    @JSONField(name = "role_id")
    @JsonProperty("role_id")
    @Column(name = "role_id")
    var roleId: String? = ""

    @JSONField(name = "follow_count")
    @JsonProperty("follow_count")
    @Column(name = "follow_count")
    var followCount: Int = 0

    @JSONField(name = "nick_name")
    @JsonProperty("nick_name")
    @Column(name = "nick_name")
    var nickName: String? = ""

    @JSONField(name = "phone_number")
    @JsonProperty("phone_number")
    @Column(name = "phone_number")
    var phoneNumber: String? = ""

    @JSONField(name = "token")
    @JsonProperty("token")
    @Column(name = "token")
    var token: String? = ""

    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    @Column(name = "avatar")
    var avatar: String? = ""
}