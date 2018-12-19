package com.viet.news.controller

import com.viet.news.common.ResponseContent
import com.viet.news.entity.ChannelList
import com.viet.news.repository.ChannelRepository
import com.viet.news.service.ChannelService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/channel")
class ChannelController {
    private val logger = LoggerFactory.getLogger(ChannelController::class.java)
    @Autowired
    var channelService: ChannelService? = null

    @PostMapping("/list")
    fun list(): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", channelService?.list())
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    @PostMapping("/allList")
    fun allList(): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", channelService?.allList())
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }
}
