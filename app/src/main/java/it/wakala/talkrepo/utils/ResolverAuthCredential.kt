package it.wakala.talkrepo.utils

import android.content.Context
import timber.log.Timber

object ResolverAuthCredential {

    private val TAG = ResolverAuthCredential::class.java.name

    const val AUTH_CREDENTIAL = "credential/auth_credential_" + "%s" + ".xml"

    fun getPublicKey(fileName: String, context: Context): String {
        var publicKey = ""
        try {
            val inputStream = context.assets.open(fileName)
            publicKey = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.PUBLIC_KEY)
        } catch (e: Throwable) {
            Timber.d(e)
        }
        return publicKey
    }

    fun getPrivateKey(fileName: String, context: Context): String {
        var privateKey = ""
        try {
            val inputStream = context.assets.open(fileName)
            privateKey = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.PRIVATE_KEY)
        } catch (e: Throwable) {
            Timber.d(e)
        }
        return privateKey
    }
}