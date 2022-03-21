package it.wakala.talkrepo.utils

import kotlinx.coroutines.CompletableDeferred

interface IPagingSourceViewModelCallback<T : Any> {

    suspend fun onLoadMore(
        nextPage: Int,
        completableDeferred: CompletableDeferred<List<T>>
    )

}