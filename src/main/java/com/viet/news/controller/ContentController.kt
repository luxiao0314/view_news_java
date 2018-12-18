package com.viet.news.controller

import com.viet.news.common.ResponseContent
import com.viet.news.entity.params.ListParams
import com.viet.news.service.ContentService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/content")
class ContentController {
    private val logger = LoggerFactory.getLogger(ContentController::class.java)
    @Autowired
    var contentService: ContentService? = null

    @GetMapping("/list4Channel")
    @ResponseBody
    fun getlist4Channel(@RequestBody listParams: ListParams): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", contentService?.getlist4Channel(listParams.channel_id))
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }
}
