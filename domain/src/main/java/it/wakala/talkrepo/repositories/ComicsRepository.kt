package it.wakala.talkrepo.repositories

import it.wakala.talkrepo.comics.ComicsEntity

interface ComicsRepository {

    suspend fun fetchComics(offset: Int): ArrayList<ComicsEntity>

}