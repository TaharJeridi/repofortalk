package it.wakala.talkrepo

import android.util.Log

object LogHelper {

    fun v(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message)
        }
    }

    fun i(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message)
        }
    }

    fun e(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message)
        }
    }

    fun d(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message)
        }
    }

    fun printStackTrace(tag: String, throwable: Throwable) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, Log.getStackTraceString(throwable))
        }
    }
}