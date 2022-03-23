package com.ywlee.kbapplication.api

import com.ywlee.kbapplication.data.VideoModel

object KakaoRepository {
    private val kakaoClient = KakaoService.client

    suspend fun getImages(query: String) =
        kakaoClient?.getImages(query)?.body()

    suspend fun getVideos(query: String, callback: GetDataCallback<VideoModel>) =
        kakaoClient?.getVideos(query)

    interface GetDataCallback<T> {
        fun onSuccess(data: T?)
        fun onFailure(throwable: Throwable)
    }
}