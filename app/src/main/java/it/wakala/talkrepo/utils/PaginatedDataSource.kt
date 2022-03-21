package it.wakala.talkrepo.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.CompletableDeferred

class PaginatedDataSource<T : Any>(
    var pagingSourceViewModelCallback: IPagingSourceViewModelCallback<T>?,
) : PagingSource<Int, T>() {

    private var resultNextPage: List<T> = ArrayList()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val nextPage = params.key ?: 0
            val completableDeferred = CompletableDeferred<List<T>>()
            pagingSourceViewModelCallback?.onLoadMore(
                nextPage,
                completableDeferred
            )
            resultNextPage = completableDeferred.await()
            LoadResult.Page(
                data = resultNextPage,
                prevKey = if (nextPage == 0) null else nextPage.minus(1),
                nextKey = if (resultNextPage.isEmpty()
                ) null else nextPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return null
    }

}