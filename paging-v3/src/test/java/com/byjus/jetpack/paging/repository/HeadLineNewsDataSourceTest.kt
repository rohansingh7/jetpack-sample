package com.byjus.jetpack.paging.repository

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadParams.Refresh
import androidx.paging.PagingSource.LoadResult.Page
import com.byjus.jetpack.base.exception.EmptyResponseException
import com.byjus.jetpack.paging.TestUtils
import com.byjus.jetpack.paging.feature.HeadLineEntityState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.test.assertEquals
import org.junit.Before

@OptIn(ExperimentalCoroutinesApi::class)
class HeadLineNewsDataSourceTest {

    private lateinit var dataSource: HeadLineNewsDataSource

    @MockK
    private lateinit var repository: IHeadLineNewsRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dataSource = HeadLineNewsDataSource(repository)
    }

    @Test
    fun loadReturnsPageWhenOnSuccessfulLoadOfPageData() = runBlockingTest {
        coEvery { repository.loadHeadLines(any()) } returns TestUtils.getHeadLineEntityState()
        assertEquals(
            expected = Page(
                data = TestUtils.getNewsEntityList(),
                prevKey = null,
                nextKey = 2
            ),
            actual = dataSource.load(
                Refresh(
                    key = null,
                    loadSize = 3,
                    placeholdersEnabled = false
                )
            ),
        )
    }

    @Test
    fun loadReturnsPageWhenOnErrorLoadOfPageData() {
        val exception = EmptyResponseException()
        runBlockingTest {
            coEvery { repository.loadHeadLines(any()) } returns HeadLineEntityState.Error(exception)
            assertEquals(
                expected = PagingSource.LoadResult.Error(
                    throwable = exception,
                ),
                actual = dataSource.load(
                    Refresh(
                        key = null,
                        loadSize = 0,
                        placeholdersEnabled = false
                    )
                ),
            )
        }
    }
}