package it.wakala.talkrepo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.wakala.talkrepo.base.coroutineExceptionHandler
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.usecase.GetMarvelCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersViewModel @Inject constructor(
    private val getMarvelCharactersUseCase: GetMarvelCharactersUseCase
): ViewModel() {

    val marvelCharactersLiveData = MutableLiveData<Result<MarvelCharsEntity>>()

    private var currentOffset = 0

    fun getMarvelCharactersList(increaseOffset: Boolean = false) {
        viewModelScope.launch(coroutineExceptionHandler) {
            withContext(Dispatchers.IO) {
                if(increaseOffset) currentOffset += 20
                val marvelCharacters = Result.success(getMarvelCharactersUseCase.execute(GetMarvelCharactersUseCase.Params(currentOffset)))
                marvelCharactersLiveData.postValue(marvelCharacters)
            }
        }
    }

}