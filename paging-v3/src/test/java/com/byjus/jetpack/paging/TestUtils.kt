package com.byjus.jetpack.paging

import com.byjus.jetpack.paging.feature.HeadLineEntity
import com.byjus.jetpack.paging.feature.HeadLineEntityState
import com.byjus.jetpack.paging.network.PagedResponse
import com.byjus.jetpack.paging.network.RemoteHeadLineModel
import com.byjus.jetpack.paging.network.RemoteSourceModel

object TestUtils {

    fun getNewsEntity(): HeadLineEntity {
        return HeadLineEntity(
            source = "CNN",
            author = "author", title = "Title", description = "news description",
            url = "http://google.com",
            urlToImage = "http://google.com",
            content = "content", publishedAt = ""
        )
    }

    fun getNewsModel(): RemoteHeadLineModel {
        return RemoteHeadLineModel(
            source = getRemoteSourceModel(),
            author = "author", title = "Title", description = "news description",
            url = "http://google.com",
            urlToImage = "http://google.com",
            content = "content", publishedAt = ""
        )
    }

    fun getNewsModelList() = listOf(getNewsModel(), getNewsModel(), getNewsModel())

    fun getNewsEntityList() = listOf(getNewsEntity(), getNewsEntity(), getNewsEntity())


    private fun getRemoteSourceModel() = RemoteSourceModel(id = "1", name = "CNN")


    fun getHeadLinePagedResponse(): PagedResponse<RemoteHeadLineModel> {
        return PagedResponse(totalResults = 1, results = listOf(getNewsModel()), status = "ok")
    }

    fun getHeadLineEntityState(): HeadLineEntityState {
        return HeadLineEntityState.Success(data = getNewsEntityList())
    }
}