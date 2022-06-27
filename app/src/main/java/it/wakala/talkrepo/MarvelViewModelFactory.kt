package it.wakala.talkrepo

import android.app.Application
import androidx.lifecycle.*
import it.wakala.talkrepo.base.UseCase
import javax.inject.Inject

class MarvelViewModelFactory<UC : UseCase<*, *>> @Inject constructor(
    val application: Application,
    private var useCase: UC,
) : ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java, useCase::class.java)
            .newInstance(application, useCase)
    }
}