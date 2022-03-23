package com.ywlee.kbapplication.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VideoModel(
    @SerializedName("meta") val meta: Meta,
    @SerializedName("documents") val documents: MutableList<Video>
) {
    data class Video(
        @SerializedName("title") val title: String,
        @SerializedName("play_time") val playTime: Int,
        @SerializedName("thumbnail") val thumbnail: String,
        @SerializedName("url") val url: String,
        @SerializedName("datetime") val dateTime: String,
        @SerializedName("author") val author: String
    )
}

/*
  "documents": [
    {
      "title": "AOA 지민·김용만, 돼지꼬리 맛에 정신혼미 ‘극찬세례’",
      "play_time": 185,
      "thumbnail": "https://search2.kakaocdn.net/argon/138x78_80_pr/FRkbdWEKr4F",
      "url": "http://tv.kakao.com/channel/2653417/cliplink/304487728?playlistId=87634",
      "datetime": "2017-05-06T00:36:45+09:00",
      "author": "_SBS"
    },
    ...
  ]
 */

