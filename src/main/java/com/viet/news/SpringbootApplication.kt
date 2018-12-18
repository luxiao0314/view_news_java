package com.viet.news

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@EnableScheduling
open class SpringbootApplication {

    @RequestMapping("/")
    fun index(): String = "Hello Spring Boot"

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringbootApplication::class.java, *args)
        }
    }
}
