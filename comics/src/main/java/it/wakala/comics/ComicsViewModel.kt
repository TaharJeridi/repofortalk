package it.wakala.comics


import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import it.wakala.talkrepo.usecase.ComicsUseCase
import it.wakala.talkrepo.base.ABaseViewModel
import it.wakala.talkrepo.extension.flowOnExceptionHandlerIO
import it.wakala.talkrepo.extension.toComicsModelViewList
import it.wakala.talkrepo.modelview.ComicsModelView
import it.wakala.talkrepo.utils.IPagingSourceViewModelCallback
import it.wakala.talkrepo.utils.PaginatedDataSource
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComicsViewModel constructor(
    application: Application,
    private val comicsUseCase: ComicsUseCase
) : ABaseViewModel(application), IPagingSourceViewModelCallback<ComicsModelView> {

    fun fetchComics(): LiveData<PagingData<ComicsModelView>> =
        Pager(PagingConfig(pageSize = 20)) {
            PaginatedDataSource(this@ComicsViewModel)
        }.flow.flowOnExceptionHandlerIO(this).asLiveData(exceptionHandler)

    override suspend fun onLoadMore(
        nextPage: Int,
        completableDeferred: CompletableDeferred<List<ComicsModelView>>
    ) {
        withContext(Dispatchers.IO){
            completableDeferred.complete(
                comicsUseCase.execute(nextPage * 20).toComicsModelViewList()
            )
        }

    }

}