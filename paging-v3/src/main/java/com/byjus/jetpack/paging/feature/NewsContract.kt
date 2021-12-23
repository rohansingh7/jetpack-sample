package com.byjus.jetpack.paging.feature

sealed class HeadLineEntityState {
    class Error(val error: Throwable) : HeadLineEntityState()

    class Success(val data: List<HeadLineEntity>) : HeadLineEntityState()
}


data class HeadLineEntity(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String,
    val source: String
)
