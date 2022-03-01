package it.wakala.talkrepo.utils

import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import timber.log.Timber
import java.io.InputStream

object XMLAuthParser {

    private val TAG = XMLAuthParser::class.java.name

    private const val PUBLIC_KEY_TAG = "public_key"

    private const val PRIVATE_KEY_TAG = "private_key"

    private const val INIT_TAG = "marvelCredential"

    fun parseXML(inputStream: InputStream, loginParserType: AuthParserType): String {
        try {
            inputStream.use {
                val parser: XmlPullParser = Xml.newPullParser()
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
                parser.setInput(inputStream, null)
                parser.nextTag()
                return readXml(parser, loginParserType)
            }
        } catch (e: Throwable) {
            Timber.e(e)
        }
        return ""
    }

    private fun readXml(parser: XmlPullParser, loginParserType: AuthParserType): String {
        var resultString = ""
        try {
            parser.require(XmlPullParser.START_TAG, null, INIT_TAG)
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.eventType != XmlPullParser.START_TAG) {
                    continue
                }
                if (parser.name == getParserValue(loginParserType)) {
                    resultString = readCredential(parser, loginParserType)
                } else {
                    skip(parser)
                }
            }
        } catch (e: Throwable) {
            Timber.e(e)
        }
        return resultString
    }

    private fun readCredential(parser: XmlPullParser, loginParserType: AuthParserType): String {
        var credential = ""
        try {
            parser.require(XmlPullParser.START_TAG, null, getParserValue(loginParserType))
            credential = readText(parser)
            parser.require(XmlPullParser.END_TAG, null, getParserValue(loginParserType))
        } catch (e: Throwable) {
            Timber.e(e)
        }
        return credential
    }

    private fun readText(parser: XmlPullParser): String {
        var resultString = ""
        try {
            if (parser.next() == XmlPullParser.TEXT) {
                resultString = parser.text
                parser.nextTag()
            }
        } catch (e: Throwable) {
            Timber.e(e)
        }
        return resultString
    }

    private fun skip(parser: XmlPullParser) {
        try {
            if (parser.eventType != XmlPullParser.START_TAG) {
                throw IllegalStateException()
            }
            var depth = 1
            while (depth != 0) {
                when (parser.next()) {
                    XmlPullParser.END_TAG -> depth--
                    XmlPullParser.START_TAG -> depth++
                }
            }
        } catch (e: Throwable) {
            Timber.e(e)
        }
    }

    private fun getParserValue(loginParserType: AuthParserType): String {
        try {
            return when (loginParserType) {
                AuthParserType.PRIVATE_KEY -> PRIVATE_KEY_TAG
                AuthParserType.PUBLIC_KEY -> PUBLIC_KEY_TAG
            }
        } catch (e: Throwable) {
            Timber.d(e)
        }
        return ""
    }

    enum class AuthParserType {
        PUBLIC_KEY,
        PRIVATE_KEY
    }

}