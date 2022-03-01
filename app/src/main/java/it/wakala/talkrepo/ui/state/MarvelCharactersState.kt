package it.wakala.talkrepo.ui.state

import it.wakala.talkrepo.ui.uimodel.MarvelCharactersResult

sealed class MarvelCharactersState(
    open val marvelCharactersResultUiModel: List<MarvelCharactersResult>? = null
)

object Loading : MarvelCharactersState()

data class Success(
    override val marvelCharactersResultUiModel: List<MarvelCharactersResult>
) : MarvelCharactersState(marvelCharactersResultUiModel)