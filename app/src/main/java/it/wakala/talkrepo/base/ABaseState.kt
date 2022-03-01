package it.wakala.talkrepo.base

sealed class StatefulData<out T: Any> {
    data class Success<T : Any> (val result : T) : StatefulData<T>()
    data class Error (val error : Throwable) : StatefulData<Nothing>()
    object Loading : StatefulData<Nothing>()
}