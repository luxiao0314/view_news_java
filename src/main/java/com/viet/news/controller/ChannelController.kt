package com.viet.news.controller

import com.viet.news.common.ResponseContent
import com.viet.news.entity.ChannelList
import com.viet.news.repository.ChannelRepository
import com.viet.news.service.ChannelService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/channel")
class ChannelController {
    private val logger = LoggerFactory.getLogger(ChannelController::class.java)
    @Autowired
    var channelService: ChannelService? = null

    @GetMapping("/list")
    @ResponseBody
    fun list(): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", channelService?.list())
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }

    @GetMapping("/allList")
    @ResponseBody
    fun allList(): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", channelService?.allList())
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }
}
