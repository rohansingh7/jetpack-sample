package com.byjus.jetpack.paging.dependencies

import com.byjus.jetpack.paging.mapper.HeadLineRemoteToEntityMapper
import com.byjus.jetpack.paging.network.NewsApi
import com.byjus.jetpack.paging.repository.IHeadLineNewsRepository
import com.byjus.jetpack.paging.repository.HeadLineNewsRepositoryImpl
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.Module


@InstallIn(dagger.hilt.components.SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun providesHeadLineNewsRepository(
        remoteApi: NewsApi,
        remoteMapper: HeadLineRemoteToEntityMapper
    ): IHeadLineNewsRepository {
        return HeadLineNewsRepositoryImpl(remote = remoteApi, remoteMapper = remoteMapper)
    }
}