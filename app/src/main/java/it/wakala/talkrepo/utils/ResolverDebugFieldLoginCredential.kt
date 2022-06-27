package it.wakala.talkrepo.utils

import android.content.Context
import it.wakala.talkrepo.LogHelper

object ResolverDebugFieldLoginCredential {

    private val TAG = ResolverDebugFieldLoginCredential::class.java.name

    private const val FIELD_LOGIN_CREDENTIAL = "credential/debug_field.xml"

    fun getName(context: Context): String {
        var name = ""
        try {
            val inputStream = context.assets.open(FIELD_LOGIN_CREDENTIAL)
            name = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.NAME)
        } catch (e: Throwable) {
            LogHelper.printStackTrace(TAG,e)
        }
        return name
    }

    fun getSurname(context: Context): String {
        var surname = ""
        try {
            val inputStream = context.assets.open(FIELD_LOGIN_CREDENTIAL)
            surname = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.SURNAME)
        } catch (e: Throwable) {
            LogHelper.printStackTrace(TAG,e)
        }
        return surname
    }

    fun getMail(context: Context): String {
        var mail = ""
        try {
            val inputStream = context.assets.open(FIELD_LOGIN_CREDENTIAL)
            mail = XMLAuthParser.parseXML(inputStream, XMLAuthParser.AuthParserType.MAIL)
        } catch (e: Throwable) {
            LogHelper.printStackTrace(TAG,e)
        }
        return mail
    }
}