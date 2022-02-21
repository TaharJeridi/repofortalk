package repositories

import kotlinx.coroutines.flow.Flow
import models.PokemonDescriptionEntity
import models.PokemonEntity

interface PokedexRepository {

    fun getPokemonList(offset: Int?): Flow<List<PokemonEntity>>

    fun getPokemonDescriptions(pokemonId: Int): Flow<PokemonDescriptionEntity>

}