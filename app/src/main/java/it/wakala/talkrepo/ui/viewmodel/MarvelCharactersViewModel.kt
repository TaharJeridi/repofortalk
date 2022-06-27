package it.wakala.talkrepo.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import it.wakala.talkrepo.base.ABaseViewModel
import it.wakala.talkrepo.ui.uimodel.MarvelCharactersResult
import it.wakala.talkrepo.ui.uimodel.toUiModel
import it.wakala.talkrepo.usecase.GetMarvelCharactersUseCase
import it.wakala.talkrepo.utils.IPagingSourceViewModelCallback
import it.wakala.talkrepo.utils.PaginatedDataSource
import kotlinx.coroutines.CompletableDeferred
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersViewModel @Inject constructor(
    application: Application,
    private val getMarvelCharactersUseCase: GetMarvelCharactersUseCase
) : ABaseViewModel(application), IPagingSourceViewModelCallback<MarvelCharactersResult> {


    override suspend fun onLoadMore(
        nextPage: Int,
        completableDeferred: CompletableDeferred<List<MarvelCharactersResult>>
    ) {
        try {
            completableDeferred.complete(
                getMarvelCharactersUseCase.execute(GetMarvelCharactersUseCase.Params(nextPage * 20)).data.results.map { it.toUiModel() }
            )
        } catch (e: Throwable) {
            //do nothing here
        }
    }

    fun fetchMarvelCharactersList(): LiveData<PagingData<MarvelCharactersResult>> =
            Pager(PagingConfig(pageSize = 20)) {
                PaginatedDataSource(this@MarvelCharactersViewModel)
            }.liveData

}