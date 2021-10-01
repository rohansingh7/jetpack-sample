package com.byjus.jetpack.paging.network

import com.byjus.jetpack.base.constants.DEFAULT_COUNTRY
import com.byjus.jetpack.base.constants.DEFAULT_PAGE_SIZE
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun fetchTopHeadLines(
        @Query("country") countryCode: String? = DEFAULT_COUNTRY,
        @Query("pageSize") pageSize: Int = DEFAULT_PAGE_SIZE,
        @Query("page") page: Int? = 1
    ): PagedResponse<RemoteHeadLineModel>
}