package com.viet.news.entity

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Table


class NewsListEntity(var total_count: Int?, var total_pages: Int?, var list: List<NewsListBean>?)

data class NewsListBean(var content: ContentBean?, var author: UserInfoEntity?, var image_array: ArrayList<ImageEntity>?)

@Data
@Entity
@Table(name = "content")
class ContentBean : BaseEntity() {
    var content_title: String? = ""
    var like_flag: Boolean = false
    var collection_flag: Boolean = false
    var content_image: String? = ""
    var content_detail: String? = ""
    var content_type: Int = 0
    var user_id: String? = "" //个人主页采用此id
    var like_number: Int = 0
    var view_number: Int = 0
    var collection_number: Int = 0
    var content_profit: Int = 0
}

data class ImageEntity(var cover: String? = "")