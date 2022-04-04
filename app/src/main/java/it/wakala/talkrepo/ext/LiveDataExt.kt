package it.wakala.talkrepo.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import it.wakala.talkrepo.base.StatefulData

fun <T : Any> MutableLiveData<Result<StatefulData<T>>>.postSuccess(value: T) {
    this.postValue(Result.success(StatefulData.Success(value)))
}

fun <T : Any> MutableLiveData<Result<StatefulData<T>>>.postLoading() {
    this.postValue(Result.success(StatefulData.Loading))
}

fun <T : Throwable> MutableLiveData<StatefulData.Error>.postFailure(value: T) {
    this.postValue((StatefulData.Error(value)))
}

fun <T: Any> LiveData<Result<StatefulData<T>>>.observeStates(lifecycleOwner: LifecycleOwner, success: (T) -> Unit, loading: () -> Unit) {
    observe(lifecycleOwner) {
        when(val value = it.getOrNull()) {
            is StatefulData.Success<T> -> {
                success.invoke(value.result)
            }

            is StatefulData.Loading -> {
                loading.invoke()
            }
            else -> return@observe
        }
    }
}