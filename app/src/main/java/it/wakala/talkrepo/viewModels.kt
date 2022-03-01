package it.wakala.talkrepo

import android.app.Application
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.repositories.IRepository

@MainThread
inline fun <reified VM : ViewModel> Fragment.marvelViewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this }
): Lazy<VM> {
    val parameterList = VM::class.java.constructors[0].parameterTypes
    val firstParameter = parameterList[1].asSubclass(UseCase::class.java)
    val parameterUseCase = firstParameter.constructors[0].parameterTypes
    val firstParameterUseCase = parameterUseCase[0].asSubclass(IRepository::class.java)
    return createViewModelLazy(
        VM::class, { ownerProducer().viewModelStore },
        {
            MarvelViewModelFactory(
                requireContext().applicationContext as Application,
                firstParameter,
                firstParameterUseCase
            )
        }
    )
}