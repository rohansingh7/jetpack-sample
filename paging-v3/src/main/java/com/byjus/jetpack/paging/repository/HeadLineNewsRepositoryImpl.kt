package com.byjus.jetpack.paging.repository

import com.byjus.jetpack.paging.feature.HeadLineEntityState
import com.byjus.jetpack.paging.mapper.HeadLineRemoteToEntityMapper
import com.byjus.jetpack.paging.network.NewsApi
import timber.log.Timber

class HeadLineNewsRepositoryImpl(
    private val remote: NewsApi,
    private val remoteMapper: HeadLineRemoteToEntityMapper
) : IHeadLineNewsRepository {

    override suspend fun loadHeadLines(page: Int?): HeadLineEntityState {
        return try {
            val response = remote.fetchTopHeadLines(page = page)
            HeadLineEntityState.Success(
                data = response.results.map { remoteModel ->
                    remoteMapper.mapToEntity(remoteModel)
                }
            )

        } catch (e: Exception) {
            Timber.e(e)
            HeadLineEntityState.Error(e)
        }
    }
}