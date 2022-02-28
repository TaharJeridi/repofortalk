package it.wakala.talkrepo.base

import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
    Timber.e(exception)
}