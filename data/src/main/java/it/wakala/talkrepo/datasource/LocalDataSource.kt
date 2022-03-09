package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity


interface LocalDataSource {
    suspend fun login(name: String, surname: String): LoginEntity
}