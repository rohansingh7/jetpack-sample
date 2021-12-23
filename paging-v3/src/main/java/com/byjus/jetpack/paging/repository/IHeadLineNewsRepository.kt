package com.byjus.jetpack.paging.repository

import com.byjus.jetpack.paging.feature.HeadLineEntityState

interface IHeadLineNewsRepository {

    suspend fun loadHeadLines(page: Int? = 1): HeadLineEntityState
}