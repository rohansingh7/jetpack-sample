package com.byjus.jetpack.paging.network

import com.google.gson.annotations.SerializedName

data class PagedResponse<T>(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int? = 0,
    @SerializedName("articles")
    val results: List<T> = emptyList()
)