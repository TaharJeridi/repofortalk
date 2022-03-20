package it.wakala.comics


import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import it.wakala.talkrepo.usecase.ComicsUseCase
import it.wakala.talkrepo.base.ABaseViewModel
import it.wakala.talkrepo.extension.flowOnExceptionHandlerIO
import it.wakala.talkrepo.extension.toComicsModelViewList
import it.wakala.talkrepo.modelview.ComicsModelView
import kotlinx.coroutines.flow.flow

class ComicsViewModel constructor(
    application: Application,
    private val comicsUseCase: ComicsUseCase
) : ABaseViewModel(application) {

    fun fetchComics(): LiveData<ArrayList<ComicsModelView>> = flow {
        emit(comicsUseCase.execute(null).toComicsModelViewList())
    }.flowOnExceptionHandlerIO(this).asLiveData(exceptionHandler)
}