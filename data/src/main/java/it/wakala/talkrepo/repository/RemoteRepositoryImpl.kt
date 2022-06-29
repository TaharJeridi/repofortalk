package it.wakala.talkrepo.repository

import it.wakala.talkrepo.datasource.RemoteDataSource
import it.wakala.talkrepo.entity.MarvelCharsEntity
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : RemoteRepository {
    override suspend fun getAllCharacters(offset: Int): MarvelCharsEntity {
        return remoteDataSource.getMarvelCharacters(offset)
    }
}