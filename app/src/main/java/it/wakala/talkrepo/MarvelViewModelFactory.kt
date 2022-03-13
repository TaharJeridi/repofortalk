package it.wakala.talkrepo

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import it.wakala.talkrepo.base.UseCase
import javax.inject.Inject

class MarvelViewModelFactory<UC : UseCase<*, *>> @Inject constructor(
    val application: Application,
    private var useCase: UC,
) : ViewModelProvider.AndroidViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return modelClass.getConstructor(Application::class.java, useCase::class.java)
            .newInstance(application, useCase)
    }

}