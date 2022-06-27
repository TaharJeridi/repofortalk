package it.wakala.talkrepo.utils

import android.content.Context
import it.wakala.talkrepo.LogHelper

object ResolverAuthCredential {

    private val TAG = ResolverAuthCredential::class.java.name

    const val AUTH_CREDENTIAL = "credential/auth_credential_" + "%s" + ".xml"

    fun getPublicKey(fileName: String, context: Context): String {
        var publicKey = ""
        try {
            val inputStream = context.assets.open(fileName)
            publicKey = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.PUBLIC_KEY)
        } catch (e: Throwable) {
            LogHelper.printStackTrace(TAG,e)
        }
        return publicKey
    }

    fun getPrivateKey(fileName: String, context: Context): String {
        var privateKey = ""
        try {
            val inputStream = context.assets.open(fileName)
            privateKey = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.PRIVATE_KEY)
        } catch (e: Throwable) {
            LogHelper.printStackTrace(TAG,e)
        }
        return privateKey
    }

    fun getMail(fileName: String, context: Context): String {
        var mail = ""
        try {
            val inputStream = context.assets.open(fileName)
            mail = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.MAIL)
        } catch (e: Throwable) {
            LogHelper.printStackTrace(TAG,e)
        }
        return mail
    }
}