package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.database.ComicsTable


interface ComicsLocalDataSource {

    suspend fun insertComics(comicsTable: ComicsTable)

}