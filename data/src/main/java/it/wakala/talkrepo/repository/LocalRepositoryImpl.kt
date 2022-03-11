package it.wakala.talkrepo.repository

import it.wakala.talkrepo.datasource.LocalDataSource
import it.wakala.talkrepo.datasource.RemoteDataSource
import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.repositories.LocalRepository
import it.wakala.talkrepo.repositories.RemoteRepository
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : LocalRepository {

    override suspend fun login(mail: String, name: String, surname: String): LoginEntity {
        return localDataSource.login(mail, name, surname)
    }

}