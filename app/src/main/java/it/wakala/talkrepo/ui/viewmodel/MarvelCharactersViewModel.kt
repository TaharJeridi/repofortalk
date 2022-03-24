package it.wakala.talkrepo.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.wakala.talkrepo.base.ABaseViewModel
import it.wakala.talkrepo.base.StatefulData
import it.wakala.talkrepo.ui.uimodel.MarvelCharactersResult
import it.wakala.talkrepo.ui.uimodel.toUiModel
import it.wakala.talkrepo.usecase.GetMarvelCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersViewModel @Inject constructor(
    application: Application,
    private val getMarvelCharactersUseCase: GetMarvelCharactersUseCase
) : ABaseViewModel(application) {

    val marvelCharactersLiveData =
        MutableLiveData<Result<StatefulData<List<MarvelCharactersResult>>>>()

    private var currentOffset = 0

    fun getMarvelCharactersList(increaseOffset: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
                marvelCharactersLiveData.postValue(Result.success(StatefulData.Loading))
                if (increaseOffset) currentOffset += 20
                val marvelCharacters = getMarvelCharactersUseCase.execute(
                    GetMarvelCharactersUseCase.Params(currentOffset)
                )
                marvelCharactersLiveData.postValue(
                    Result.success(
                        StatefulData.Success<List<MarvelCharactersResult>>(
                            marvelCharacters.data.results.map { it.toUiModel() })
                    )
                )
        }
    }

}