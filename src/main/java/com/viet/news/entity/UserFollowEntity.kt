package com.viet.news.entity

import com.alibaba.fastjson.annotation.JSONField
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModelProperty
import lombok.Data
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Data
@Entity
@Table(name = "user_follow")
class UserFollowEntity : BaseEntity() {

    @JSONField(name = "user_id")
    @JsonProperty("user_id")
    @Column(name = "user_id")
    var userId: Long? = 0

    @JSONField(name = "follow_user_id")
    @JsonProperty("follow_user_id")
    @Column(name = "follow_user_id")
    var followUserId: Long? = 0
}