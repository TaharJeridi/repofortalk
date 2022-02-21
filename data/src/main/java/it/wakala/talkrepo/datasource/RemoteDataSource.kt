package it.mirco.pokedex.datasource

import kotlinx.coroutines.flow.Flow
import models.PokemonDescriptionEntity
import models.PokemonEntity

interface PokedexDataSource {

    fun getPokemonsList(offset: Int?): Flow<List<PokemonEntity>>

    fun getPokemonDescription(pokemonId: Int): Flow<PokemonDescriptionEntity>

}