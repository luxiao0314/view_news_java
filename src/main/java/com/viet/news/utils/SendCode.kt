package com.viet.news.utils

import com.alibaba.fastjson.JSONObject
import com.viet.news.entity.SMSCodeResponse
import java.util.ArrayList
import java.util.Date

import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils

/**
 * 发送验证码
 * @author liuxuanlin
 */
object SendCode {
    //发送验证码的请求路径URL
    private val SERVER_URL = "https://api.netease.im/sms/sendcode.action"
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private val APP_KEY = "7d41536768e8332745a492edeb3550f3"
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private val APP_SECRET = "d0e6d39f781f"
    //随机数
    private val NONCE = "123456"
    //短信模板ID
    private val TEMPLATEID = "9284697"
    //手机号
    private val MOBILE = "17602129432"
    //验证码长度，范围4～10，默认为4
    private val CODELEN = "6"

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {

        val httpClient = DefaultHttpClient()
        val httpPost = HttpPost(SERVER_URL)
        val curTime = (Date().time / 1000L).toString()
        /*
         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
         */
        val checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime)

        // 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY)
        httpPost.addHeader("Nonce", NONCE)
        httpPost.addHeader("CurTime", curTime)
        httpPost.addHeader("CheckSum", checkSum)
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")

        // 设置请求的的参数，requestBody参数
        val nvps = ArrayList<NameValuePair>()
        /*
         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
         */
        nvps.add(BasicNameValuePair("templateid", TEMPLATEID))
        nvps.add(BasicNameValuePair("mobile", MOBILE))
        nvps.add(BasicNameValuePair("codeLen", CODELEN))

        httpPost.entity = UrlEncodedFormEntity(nvps, "utf-8")

        // 执行请求
        val response = httpClient.execute(httpPost)
        /*
         * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
         * 2.具体的code有问题的可以参考官网的Code状态表
         */
        println(EntityUtils.toString(response.entity, "utf-8"))

    }

    fun sendCode(mobile: String?): SMSCodeResponse? {
        val httpClient = DefaultHttpClient()
        val httpPost = HttpPost(SERVER_URL)
        val curTime = (Date().time / 1000L).toString()
        /*
         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
         */
        val checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime)

        // 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY)
        httpPost.addHeader("Nonce", NONCE)
        httpPost.addHeader("CurTime", curTime)
        httpPost.addHeader("CheckSum", checkSum)
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")

        // 设置请求的的参数，requestBody参数
        val nvps = ArrayList<NameValuePair>()
        /*
         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
         */
        nvps.add(BasicNameValuePair("templateid", TEMPLATEID))
        nvps.add(BasicNameValuePair("mobile", mobile))
        nvps.add(BasicNameValuePair("codeLen", CODELEN))

        httpPost.entity = UrlEncodedFormEntity(nvps, "utf-8")

        // 执行请求
        val response = httpClient.execute(httpPost)
        /*
         * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
         * 2.具体的code有问题的可以参考官网的Code状态表
         */
        return JSONObject.parseObject(EntityUtils.toString(response.entity, "utf-8"), SMSCodeResponse::class.java)
    }
}