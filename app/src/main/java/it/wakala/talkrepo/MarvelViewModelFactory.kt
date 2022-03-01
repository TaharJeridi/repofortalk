package it.wakala.talkrepo

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.repositories.IRepository
import it.wakala.talkrepo.ui.App
import java.lang.RuntimeException

class MarvelViewModelFactory<UC : UseCase<*, *>, RP : IRepository>(
    private val application: Application,
    private val useCase: Class<UC>,
    private val repositoryCall: Class<RP>
) : ViewModelProvider.AndroidViewModelFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return if (AndroidViewModel::class.java.isAssignableFrom(modelClass)) {
            return try {
                when {
                    viewModelNotRequiredInjection(modelClass) -> {
                        modelClass.newInstance()
                    }
                    viewModelRequireInjectOnlyApplication(modelClass) -> {
                        modelClass.getConstructor(Application::class.java)
                            .newInstance(application)
                    }
                    viewModelRequireInjectApplicationAndUseCase(modelClass, useCase) -> {
                        val repositoryInstance = getRepository(repositoryCall)
                        val useCaseInstance = getUseCase(useCase,repositoryInstance)
                        App.appContainer.repositoryContainer.saveRepository(
                            repositoryInstance::class.java.name,
                            repositoryInstance
                        )
                        App.appContainer.useCaseContainer.saveUseCase(
                            useCaseInstance::class.java.name,
                            useCaseInstance
                        )
                        modelClass.getConstructor(Application::class.java, useCase)
                            .newInstance(
                                application,
                                useCaseInstance
                            )
                    }
                    else -> {
                        throw RuntimeException("viewModel not recognized")
                    }
                }
            } catch (e: Throwable) {
                throw RuntimeException("viewModel not recognized")
            }
        } else {
            super.create(modelClass, extras)
        }
    }

    private fun <T : ViewModel> viewModelRequireInjectOnlyApplication(modelClass: Class<T>): Boolean {
        val firstConstructor = modelClass.constructors[0]
        val parameterConstructor = firstConstructor.parameterTypes
        if (parameterConstructor.size == 1 && parameterConstructor.contains(Application::class.java)) {
            return true
        }
        return false
    }


    private fun <T : ViewModel, UC : UseCase<*, *>> viewModelRequireInjectApplicationAndUseCase(
        modelClass: Class<T>,
        useCase: Class<UC>
    ): Boolean {
        val firstConstructor = modelClass.constructors[0]
        val parameterConstructor = firstConstructor.parameterTypes
        if (parameterConstructor.size == 2 && parameterConstructor.contains(Application::class.java) && parameterConstructor.contains(
                useCase
            )
        ) {
            return true
        }
        return false
    }

    private fun <T : ViewModel> viewModelNotRequiredInjection(modelClass: Class<T>): Boolean {
        val firstConstructor = modelClass.constructors[0]
        val parameterConstructor = firstConstructor.parameterTypes
        if (parameterConstructor.isEmpty()) {
            return true
        }
        return false
    }

    @Suppress("UNCHECKED_CAST")
    private fun <UC : UseCase<*, *>> getUseCase(useCase: Class<UC>, repositoryInstance:RP): UC {
        App.appContainer.useCaseContainer.getUseCase(useCase.name)?.let {
            return it as UC
        } ?: kotlin.run {
            return useCase.getConstructor(repositoryCall)
                .newInstance(repositoryInstance)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun getRepository(repository: Class<RP>): RP {
        App.appContainer.repositoryContainer.getRepository(repository.name)?.let {
            return it as RP
        } ?: kotlin.run {
            return repository.getConstructor()
                .newInstance()
        }
    }


}