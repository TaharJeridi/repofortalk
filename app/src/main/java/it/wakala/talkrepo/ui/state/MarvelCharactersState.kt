package it.wakala.talkrepo.ui.state

import it.wakala.talkrepo.entity.MarvelCharsEntity

sealed class MarvelCharactersState()

object Loading : MarvelCharactersState()

data class Success(
    val marvelCharsEntity: MarvelCharsEntity
) : MarvelCharactersState()
