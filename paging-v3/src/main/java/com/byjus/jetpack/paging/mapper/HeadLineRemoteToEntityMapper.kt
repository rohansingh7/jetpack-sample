package com.byjus.jetpack.paging.mapper

import com.byjus.jetpack.base.mapper.RemoteToEntityMapper
import com.byjus.jetpack.paging.feature.HeadLineEntity
import com.byjus.jetpack.paging.network.RemoteHeadLineModel
import javax.inject.Inject

class HeadLineRemoteToEntityMapper @Inject constructor() :
    RemoteToEntityMapper<RemoteHeadLineModel, HeadLineEntity> {

    override fun mapToEntity(remote: RemoteHeadLineModel): HeadLineEntity {
        return HeadLineEntity(
            remote.author?: "", remote.title?: "", remote.description?: "", remote.url?: "",
            remote.urlToImage, remote.publishedAt, remote.content?: "", remote.source?.name ?: ""
        )
    }

}