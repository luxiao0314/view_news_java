package com.viet.news.entity

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Table

@Data
@Entity
@Table(name = "content")
class NewsListEntity(var total_count: String?, var total_pages: String?, var list: List<NewsListBean>)

data class NewsListBean(var content: ContentBean, var author: UserInfoEntity, var image_array: ArrayList<ImageEntity>)

data class ContentBean(var content_title: String?,
                       var like_flag: Boolean,
                       var collection_flag: Boolean,
                       var content_image: String?,
                       var content_detail: String?,
                       var content_type: Int,
                       var user_id: String?, //个人主页采用此id
                       var like_number: Int,
                       var view_number: Int,
                       var collection_number: Int,
                       var content_profit: Int) : BaseEntity()

data class ImageEntity(var cover: String? = "")