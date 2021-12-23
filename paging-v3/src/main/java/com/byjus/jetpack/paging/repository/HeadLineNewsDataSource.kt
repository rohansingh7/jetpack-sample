package com.byjus.jetpack.paging.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.byjus.jetpack.paging.feature.HeadLineEntity
import com.byjus.jetpack.paging.feature.HeadLineEntityState
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class HeadLineNewsDataSource @Inject constructor(private val repository: IHeadLineNewsRepository) :
    PagingSource<Int, HeadLineEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HeadLineEntity> {
        val page = params.key ?: 1
        val state = repository.loadHeadLines(page = page)
        if (state is HeadLineEntityState.Success) {
            val prevKey = if (page == 1) null else page -1
            return LoadResult.Page(
                data = state.data, prevKey = prevKey, nextKey = page + 1)
        }

        return LoadResult.Error(throwable = (state as HeadLineEntityState.Error).error)
    }

    override fun getRefreshKey(state: PagingState<Int, HeadLineEntity>): Int? {
       /* return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
        */

        return null
    }
}