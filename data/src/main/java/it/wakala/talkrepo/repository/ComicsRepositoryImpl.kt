package it.wakala.talkrepo.repository

import it.wakala.talkrepo.repositories.ComicsRepository
import it.wakala.talkrepo.comics.ComicsEntity
import it.wakala.talkrepo.datasource.ComicsRemoteDataSource
import it.wakala.talkrepo.extension.toComicsEntityList

class ComicsRepositoryImpl(private val comicsRemoteDataSource: ComicsRemoteDataSource) :
    ComicsRepository {

    override suspend fun fetchComics(): ArrayList<ComicsEntity> {
        return comicsRemoteDataSource.getMarvelComics().toComicsEntityList()
    }

}