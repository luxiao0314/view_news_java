package com.viet.news.entity


import lombok.Data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Data
@Entity
@Table(name = "person")
class ChannelList {

    @Id
    @GeneratedValue
    var id: Long? = null

    var name: String? = null

    var address: String? = null
}
