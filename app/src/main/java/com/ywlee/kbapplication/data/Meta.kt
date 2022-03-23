package com.ywlee.kbapplication.data

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("total_count") val total_count: Int,
    @SerializedName("pageable_count") val pageableCount: Int,
    @SerializedName("is_end") val isEnd: Boolean
)

/*
  "meta": {
    "total_count": 6033,
    "pageable_count" : 800,
    "is_end": false
  },
 */