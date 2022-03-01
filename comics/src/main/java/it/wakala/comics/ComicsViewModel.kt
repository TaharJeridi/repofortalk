package it.wakala.comics


import android.app.Application
import androidx.lifecycle.viewModelScope
import it.wakala.talkrepo.base.ABaseViewModel

import it.wakala.talkrepo.base.comics.ComicsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicsViewModel constructor(
    application: Application,
    private val comicsUseCase: ComicsUseCase
) : ABaseViewModel(application) {

    fun fetchComics() {
        viewModelScope.launch(){
            withContext(Dispatchers.IO){
                comicsUseCase.execute(null)
            }
        }
    }
}