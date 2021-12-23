package com.byjus.jetpack.paging.repository

import com.byjus.jetpack.paging.TestUtils
import com.byjus.jetpack.paging.feature.HeadLineEntityState
import com.byjus.jetpack.paging.mapper.HeadLineRemoteToEntityMapper
import com.byjus.jetpack.paging.network.NewsApi
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import org.junit.Before
import org.junit.Test
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals

internal class HeadLineNewsRepositoryImplTest {

    private lateinit var repository: IHeadLineNewsRepository

    @MockK
    private lateinit var mapper: HeadLineRemoteToEntityMapper

    @MockK
    private lateinit var remote: NewsApi

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = HeadLineNewsRepositoryImpl(remote = remote, remoteMapper = mapper)
    }

    @Test
    fun `test_loadHeadLines_returns_success`() {
        val response = TestUtils.getHeadLinePagedResponse()
        val remoteModel = TestUtils.getNewsModel()
        val newsEntity = TestUtils.getNewsEntity()
        coEvery { remote.fetchTopHeadLines(any()) } returns response
        every { mapper.mapToEntity(remoteModel) } returns newsEntity

        runBlocking {
            val result = repository.loadHeadLines()
            assertTrue(result is HeadLineEntityState.Success)
            val stateResult = result as HeadLineEntityState.Success
            assertEquals(response.results.size, stateResult.data.size)
        }

    }


}