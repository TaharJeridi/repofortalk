package it.wakala.talkrepo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.wakala.talkrepo.base.coroutineExceptionHandler
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.ui.state.Loading
import it.wakala.talkrepo.ui.state.MarvelCharactersState
import it.wakala.talkrepo.ui.state.Success
import it.wakala.talkrepo.usecase.GetMarvelCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersViewModel @Inject constructor(
    private val getMarvelCharactersUseCase: GetMarvelCharactersUseCase
) : ViewModel() {

    val marvelCharactersLiveData = MutableLiveData<Result<MarvelCharactersState>>()

    private var currentOffset = 0

    fun getMarvelCharactersList(increaseOffset: Boolean = false) {
        viewModelScope.launch(coroutineExceptionHandler) {
            withContext(Dispatchers.IO) {
                marvelCharactersLiveData.postValue(Result.success(Loading))
                if (increaseOffset) currentOffset += 20
                val marvelCharacters = getMarvelCharactersUseCase.execute(
                    GetMarvelCharactersUseCase.Params(currentOffset)
                )
                marvelCharactersLiveData.postValue(Result.success(Success(marvelCharacters)))
            }
        }
    }

}