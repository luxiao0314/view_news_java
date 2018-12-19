package com.viet.news.entity


import lombok.Data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Data
@Entity
@Table(name = "channel")
class ChannelList : BaseEntity() {
    var channel_key: String? = null
    var channel_name: String? = null
    var sort: Int = 0
    var can_delete: Boolean? = null
    var default_channel: Boolean? = null
}
