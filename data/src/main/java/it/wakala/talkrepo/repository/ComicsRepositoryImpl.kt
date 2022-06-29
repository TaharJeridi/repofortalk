package it.wakala.talkrepo.repository


import it.wakala.talkrepo.database.ComicsTable
import it.wakala.talkrepo.datasource.ComicsLocalDataSource
import it.wakala.talkrepo.datasource.ComicsRemoteDataSource
import it.wakala.talkrepo.entity.ComicsEntity
import it.wakala.talkrepo.extension.toComicsEntityList

class ComicsRepositoryImpl(
    private val comicsRemoteDataSource: ComicsRemoteDataSource,
    private val comicsLocalDataSource: ComicsLocalDataSource
) : ComicsRepository {

    override suspend fun fetchComics(offset: Int): ArrayList<ComicsEntity> {
        return comicsRemoteDataSource.getMarvelComics(offset).toComicsEntityList()
    }

    override suspend fun insertComics(comicsTable: ComicsTable) {
        comicsLocalDataSource.insertComics(comicsTable)
    }

}