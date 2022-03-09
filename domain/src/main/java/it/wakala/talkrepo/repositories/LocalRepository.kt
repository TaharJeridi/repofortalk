package it.wakala.talkrepo.repositories

import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity


interface LocalRepository {

    suspend fun login(name: String, surname: String): LoginEntity

}