package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.database.ComicsTable
import it.wakala.talkrepo.database.MarvelDataBase
import javax.inject.Inject

class ComicsLocalDataSourceImpl @Inject constructor(
    private val marvelDataBase: MarvelDataBase
) : ComicsLocalDataSource {

    override suspend fun insertComics(comicsTable: ComicsTable) {
        marvelDataBase.marvelDAO().insertComics(comicsTable)
    }

}