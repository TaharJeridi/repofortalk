package it.wakala.talkrepo.repository

import it.wakala.talkrepo.datasource.LocalDataSource
import it.wakala.talkrepo.entity.LoginEntity
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : LocalRepository {

    override suspend fun login(mail: String, name: String, surname: String): LoginEntity {
        return localDataSource.login(mail, name, surname)
    }

}