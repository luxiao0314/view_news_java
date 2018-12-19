package com.viet.news.controller

import com.viet.news.common.ResponseContent
import com.viet.news.entity.ChannelList
import com.viet.news.repository.ChannelRepository
import com.viet.news.service.ChannelService
import com.viet.news.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController {
    private val logger = LoggerFactory.getLogger(UserController::class.java)
    @Autowired
    var userService: UserService? = null

    @GetMapping("/info/{userId}")
    @ResponseBody
    fun userInfo(@PathVariable("userId") userId: String): ResponseContent<*>? {
        return try {
            ResponseContent.buildSuccess("success", userService?.getUserInfo(userId.toLong()))
        } catch (e: Exception) {
            logger.error("error", e)
            ResponseContent.buildFail("出错啦\n" + e.message)
        }
    }
}
