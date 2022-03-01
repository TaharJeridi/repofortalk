package it.wakala.talkrepo.utils

import android.content.Context
import timber.log.Timber

object ResolverAuthCredential {

    private val TAG = ResolverAuthCredential::class.java.name

    private const val AUTH_CREDENTIAL = "credential/auth_credential.xml"

    fun getPublicKey(context: Context): String {
        var publicKey = ""
        try {
            val inputStream = context.assets.open(AUTH_CREDENTIAL)
            publicKey = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.PUBLIC_KEY)
        } catch (e: Throwable) {
            Timber.d(e)
        }
        return publicKey
    }

    fun getPrivateKey(context: Context): String {
        var privateKey = ""
        try {
            val inputStream = context.assets.open(AUTH_CREDENTIAL)
            privateKey = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.PRIVATE_KEY)
        } catch (e: Throwable) {
            Timber.d(e)
        }
        return privateKey
    }
}