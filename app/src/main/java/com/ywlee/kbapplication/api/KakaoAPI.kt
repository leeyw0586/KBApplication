package com.ywlee.kbapplication.api

import com.ywlee.kbapplication.data.ImageModel
import com.ywlee.kbapplication.data.VideoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KakaoAPI {

    // datetime 필드를 이용해 정렬하여 출력합니다. (최신부터 나타나도록)
    // 검색 결과는 5분간 캐시하여, 5분 이내 동일 키워드로 검색했을 때 네트워크 통신없이 결과를 보여줍니다

//    private const val REST_API_KEY = "KakaoAK baf90697afcca2c6679ead253994fe72"

    @Headers("Authorization: KakaoAK baf90697afcca2c6679ead253994fe72")
    @GET("v2/search/image")
    suspend fun getImages(
        @Query("query") query: String,
        @Query("sort") sort: String = "recency"
    ): Response<ImageModel>


    @GET("/v2/search/vclip")
    suspend fun getVideos(
        @Query("query") query: String,
        @Query("sort") sort: String = "recency"
    ): Response<VideoModel>
}