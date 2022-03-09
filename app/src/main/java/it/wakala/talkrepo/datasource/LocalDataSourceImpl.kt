package it.wakala.talkrepo.datasource

import android.content.Context
import it.wakala.talkrepo.api.RemoteApi
import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.interceptor.AuthInterceptor
import it.wakala.talkrepo.mapper.MarvelCharsResponseEntityMapper
import it.wakala.talkrepo.utils.ResolverAuthCredential
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    val context: Context,
    private val authInterceptor: AuthInterceptor
) : LocalDataSource {

    override suspend fun login(name: String, surname: String): LoginEntity {
        val userInitials = "${name.first().uppercase()}${surname.first().uppercase()}"
        val fileName = String.format(ResolverAuthCredential.AUTH_CREDENTIAL, userInitials)

        val privateKey = ResolverAuthCredential.getPrivateKey(fileName, context)
        val publicKey = ResolverAuthCredential.getPublicKey(fileName, context)

        authInterceptor.privateKey = privateKey
        authInterceptor.publicKey = publicKey

        return LoginEntity(publicKey, privateKey)
    }
}