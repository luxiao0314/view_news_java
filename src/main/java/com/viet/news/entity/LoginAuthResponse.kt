package com.viet.news.entity

import com.alibaba.fastjson.annotation.JSONField
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Data
@Entity
@Table(name = "user_oauth")
class LoginAuthResponse : BaseEntity() {
    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @Column(name = "user_id")
    var userId: String? = ""

    var oatuh_token: String? = ""
}