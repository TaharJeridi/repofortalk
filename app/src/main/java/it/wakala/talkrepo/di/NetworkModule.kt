package it.wakala.talkrepo.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.BuildConfig
import it.wakala.talkrepo.R
import it.wakala.talkrepo.api.RemoteApi
import it.wakala.talkrepo.ext.md5
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.HashingSink
import okio.Sink
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.nio.charset.Charset
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    /*@Singleton
    @Provides
    fun provideAuthInterceptor(@ApplicationContext context: Context): AuthInterceptor = AuthInterceptor(context)*/

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        okHttpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor { chain ->
                val currentTime = System.currentTimeMillis().toString()
                val publicApiKey = context.resources.openRawResource(R.raw.public_key)
                    .bufferedReader(Charset.defaultCharset()).readLine()
                val privateApiKey = context.resources.openRawResource(R.raw.private_key)
                    .bufferedReader(Charset.defaultCharset()).readLine()

                val request = chain.request()
                val originalUrl = request.url

                val newUrl = originalUrl.newBuilder()
                    .addQueryParameter("ts", currentTime)
                    .addQueryParameter("apikey", publicApiKey)
                    .addQueryParameter("hash", "$currentTime$privateApiKey$publicApiKey".md5())
                    .build()

                val newRequest = request.newBuilder().url(newUrl).build()
                chain.proceed(newRequest)
            }
            .addInterceptor { chain ->
                val request = chain.request()
                val connectivityManager =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

                if (connectivityManager.activeNetwork != null) {
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                } else {
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                    ).build()
                }
                chain.proceed(request)
            }
            .addInterceptor(okHttpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): RemoteApi =
        retrofit.create(RemoteApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClientCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, (10 * 1024 * 1024).toLong())

}

/*
class AuthInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentTime = System.currentTimeMillis().toString()
        val publicApiKey = context.resources.openRawResource(R.raw.public_key).bufferedReader(Charset.defaultCharset()).readLine()
        val privateApiKey = context.resources.openRawResource(R.raw.private_key).bufferedReader(Charset.defaultCharset()).readLine()

        return chain.run {
            proceed(
                chain.request()
                    .newBuilder()
                    .addHeader("ts", currentTime)
                    .addHeader("apikey", publicApiKey)
                    .addHeader("hash", "$currentTime$publicApiKey$privateApiKey".md5())
                    .build()
            )
        }
    }

}*/
