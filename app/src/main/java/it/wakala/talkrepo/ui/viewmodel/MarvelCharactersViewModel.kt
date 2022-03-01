package it.wakala.talkrepo.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.wakala.talkrepo.base.ABaseViewModel
import it.wakala.talkrepo.ui.state.Loading
import it.wakala.talkrepo.ui.state.MarvelCharactersState
import it.wakala.talkrepo.ui.state.Success
import it.wakala.talkrepo.ui.uimodel.toUiModel
import it.wakala.talkrepo.usecase.GetMarvelCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersViewModel @Inject constructor(
    application: Application,
    private val getMarvelCharactersUseCase: GetMarvelCharactersUseCase
) : ABaseViewModel(application) {

    val marvelCharactersLiveData = MutableLiveData<Result<MarvelCharactersState>>()

    private var currentOffset = 0

    fun getMarvelCharactersList(increaseOffset: Boolean = false) {
        viewModelScope.launch(exceptionHandler) {
            withContext(Dispatchers.IO) {
                marvelCharactersLiveData.postValue(Result.success(Loading))
                if (increaseOffset) currentOffset += 20
                val marvelCharacters = getMarvelCharactersUseCase.execute(
                    GetMarvelCharactersUseCase.Params(currentOffset)
                )
                marvelCharactersLiveData.postValue(Result.success(Success(marvelCharacters.data.results.map { it.toUiModel() })))
            }
        }
    }

}