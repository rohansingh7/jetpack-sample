package com.byjus.jetpack.paging.network

import com.google.gson.annotations.SerializedName

data class RemoteHeadLineModel(
    @SerializedName("source")
    val source: RemoteSourceModel?,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("content")
    val content: String?
)

data class RemoteSourceModel(
    val id: String,
    val name: String
)
