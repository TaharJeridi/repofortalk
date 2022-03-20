package it.wakala.talkrepo.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import it.wakala.talkrepo.ext.postFailure
import kotlinx.coroutines.CoroutineExceptionHandler

open class ABaseViewModel(application: Application) : AndroidViewModel(application) {

    val errorLiveData = MutableLiveData<StatefulData.Error>()

    var callBackLifeCycleViewModel: LifecycleViewModelCallback? = null

    var exceptionHandler = CoroutineExceptionHandler { _, exception ->
        errorLiveData.postFailure(exception)
    }

    override fun onCleared() {
        super.onCleared()
        callBackLifeCycleViewModel?.onCleared()
    }

}