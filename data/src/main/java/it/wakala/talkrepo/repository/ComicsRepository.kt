package it.wakala.talkrepo.repository

import it.wakala.talkrepo.database.ComicsTable
import it.wakala.talkrepo.entity.ComicsEntity

interface ComicsRepository {

    suspend fun fetchComics(offset: Int): ArrayList<ComicsEntity>

    suspend fun insertComics(comicsTable: ComicsTable)

}