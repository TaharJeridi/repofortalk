package it.wakala.talkrepo

import android.app.Application
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.extension.getFirstConstructor
import it.wakala.talkrepo.extension.getFirstParameter
import it.wakala.talkrepo.extension.getSecondParameter
import it.wakala.talkrepo.repositories.IRepository

@MainThread
inline fun <reified VM : ViewModel> Fragment.marvelViewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this }
): Lazy<VM> {
    val parameterList = VM::class.java.getFirstConstructor()?.parameterTypes
    val firstParameter = parameterList.getSecondParameter()?.asSubclass(UseCase::class.java)
    val parameterUseCase = firstParameter.getFirstConstructor()?.parameterTypes
    val firstParameterUseCase = parameterUseCase.getFirstParameter()?.asSubclass(IRepository::class.java)
    return createViewModelLazy(
        VM::class, { ownerProducer().viewModelStore },
        {
            MarvelViewModelFactory(
                requireContext().applicationContext as Application,
                firstParameter!!,
                firstParameterUseCase!!
            )
        }
    )
}