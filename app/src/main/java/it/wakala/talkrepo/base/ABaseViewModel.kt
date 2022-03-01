package it.wakala.talkrepo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler

open class ABaseViewModel(application: Application) : AndroidViewModel(application) {

    val errorLiveData = MutableLiveData<StatefulData.Error>()

    var exceptionHandler = CoroutineExceptionHandler { _, exception ->
        errorLiveData.postValue(StatefulData.Error(exception))
    }

}