package com.byjus.jetpack.paging.repository

import com.byjus.jetpack.paging.TestUtils
import com.byjus.jetpack.paging.network.NewsApi
import com.byjus.jetpack.paging.network.PagedResponse
import com.byjus.jetpack.paging.network.RemoteHeadLineModel

class FakeNewsApi: NewsApi {
    override suspend fun fetchTopHeadLines(
        countryCode: String?,
        pageSize: Int,
        page: Int?
    ): PagedResponse<RemoteHeadLineModel> {
        return  PagedResponse(status = "ok", totalResults = 3, results = TestUtils.getNewsModelList())
    }
}