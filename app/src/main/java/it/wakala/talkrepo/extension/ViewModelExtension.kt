package it.wakala.talkrepo.extension

import androidx.lifecycle.ViewModel
import it.wakala.talkrepo.base.ABaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

fun <T> Flow<T>.flowOnExceptionHandlerIO(viewModel: ViewModel): Flow<T> {
    if (viewModel is ABaseViewModel) {
        return this.flowOn(viewModel.exceptionHandler + Dispatchers.IO)
    }
    return flowOn(Dispatchers.IO)
}