package it.wakala.talkrepo.interceptor

import dagger.Provides
import it.wakala.talkrepo.ext.md5
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(

): Interceptor {

    var publicKey: String? = null
    var privateKey: String? = null


    override fun intercept(chain: Interceptor.Chain): Response {
        val currentTime = System.currentTimeMillis().toString()

        val request = chain.request()
        val originalUrl = request.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("ts", currentTime)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", "$currentTime$privateKey$publicKey".md5())
            .build()

        val newRequest = request.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }
}