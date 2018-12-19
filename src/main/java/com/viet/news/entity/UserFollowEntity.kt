package com.viet.news.entity

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Table

@Data
@Entity
@Table(name = "user_follow")
class UserFollowEntity : BaseEntity() {
    var user_id: Long? = 0
    var follow_user_id: Long? = 0
}