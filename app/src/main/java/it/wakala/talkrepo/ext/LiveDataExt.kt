package it.wakala.talkrepo.ext

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