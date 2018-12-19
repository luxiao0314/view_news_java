package com.viet.news.controller

import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.viet.news.common.ResponseContent
import com.viet.news.entity.ImageEntity
import com.viet.news.entity.NewsListBean
import com.viet.news.entity.NewsListEntity
import com.viet.news.entity.params.ListParams
import com.viet.news.service.ContentService
import com.viet.news.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/content")
class ContentController {

    private val logger = LoggerFactory.getLogger(ContentController::class.java)

    @Autowired
    var contentService: ContentService? = null
    @Autowired
    var userService: UserService? = null

    @PostMapping("/list4Channel")
    @ResponseBody
    fun getlist4Channel(@RequestBody listParams: ListParams): ResponseContent<*>? {
        return try {
            val content4Channel = contentService?.getContent4Channel(listParams.channel_id)
            val newsListBean = arrayListOf<NewsListBean>()
            content4Channel?.forEach {
                val imgList = arrayListOf<ImageEntity>()
                JSONArray.parseArray(it.content_image).forEach { imgList.add(ImageEntity((it as JSONObject).getString("cover"))) }
                newsListBean.add(NewsListBean(it, userService?.getUserInfo(1), imgList))
            }
            ResponseContent.buildSuccess("success", NewsListEntity(content4Channel?.size, 20, newsListBean))
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }
}
