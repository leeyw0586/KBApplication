package com.ywlee.kbapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KakaoService {

    private const val BASE_URL = "https://dapi.kakao.com/"

    val client = getClient()?.create(KakaoAPI::class.java)

    fun getClient(): Retrofit? = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}