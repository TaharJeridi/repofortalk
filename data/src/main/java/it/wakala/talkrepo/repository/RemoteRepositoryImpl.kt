package it.wakala.talkrepo.repository

import it.wakala.talkrepo.datasource.RemoteDataSource
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.repositories.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : RemoteRepository {
    override suspend fun getAllCharacters(): MarvelCharsEntity {
        return remoteDataSource.getMarvelCharacters()
    }
}