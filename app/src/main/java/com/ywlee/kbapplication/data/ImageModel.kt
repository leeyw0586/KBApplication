package com.ywlee.kbapplication.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageModel(
    @Expose @SerializedName("meta") val meta: Meta,
    @Expose @SerializedName("documents") val documents: MutableList<Image>
) {
    data class Image(
        @SerializedName("collection") val collection: String,
        @Expose @SerializedName("thumbnail_url") val thumbnailUrl: String,
        @SerializedName("image_url") val imageUrl: String,
        @SerializedName("width") val width: Int,
        @SerializedName("height") val height: Int,
        @SerializedName("display_sitename") val displaySitename: String,
        @SerializedName("doc_url") val docUrl: String,
        @SerializedName("datetime") val dateTime: String
    )
}

/*
  "documents": [
    {
      "collection": "news",
      "thumbnail_url": "https://search2.kakaocdn.net/argon/130x130_85_c/36hQpoTrVZp",
      "image_url": "http://t1.daumcdn.net/news/201706/21/kedtv/20170621155930292vyyx.jpg",
      "width": 540,
      "height": 457,
      "display_sitename": "한국경제TV",
      "doc_url": "http://v.media.daum.net/v/20170621155930002",
      "datetime": "2017-06-21T15:59:30.000+09:00"
    },
    ...
  ]
 */

