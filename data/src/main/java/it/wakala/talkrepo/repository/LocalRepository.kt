package it.wakala.talkrepo.repository

import it.wakala.talkrepo.entity.LoginEntity


interface LocalRepository {

    suspend fun login(mail: String, name: String, surname: String): LoginEntity

}