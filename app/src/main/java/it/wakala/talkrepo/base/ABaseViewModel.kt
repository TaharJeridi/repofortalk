package it.wakala.talkrepo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

class ABaseViewModel(application: Application) : AndroidViewModel(application) {

    var exceptionHandler = CoroutineExceptionHandler { _, exception ->
    }

}