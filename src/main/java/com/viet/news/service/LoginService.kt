package com.viet.news.service

import com.viet.news.entity.LoginRegisterResponse
import com.viet.news.repository.LoginAuthRepository
import com.viet.news.repository.LoginRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService {

    @Autowired
    var loginRepository: LoginRepository? = null

    @Autowired
    var loginAuthRepository: LoginAuthRepository? = null

    fun login(phoneNumber: String?): LoginRegisterResponse? {
        val registerResponse = loginRepository?.findAllByPhoneNumber(phoneNumber)
        val token = loginAuthRepository?.getToken(registerResponse?.id)
        registerResponse?.token = token
        return registerResponse
    }

    fun getToken(userId: Long): String? {
        return loginAuthRepository?.getToken(userId)
    }
}
