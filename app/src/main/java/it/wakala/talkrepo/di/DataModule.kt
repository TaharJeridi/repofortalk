package it.wakala.talkrepo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.database.MarvelDataBase
import it.wakala.talkrepo.datasource.LocalDataSource
import it.wakala.talkrepo.datasource.LocalDataSourceImpl
import it.wakala.talkrepo.datasource.RemoteDataSourceImpl
import it.wakala.talkrepo.datasource.RemoteDataSource
import it.wakala.talkrepo.repository.LocalRepository
import it.wakala.talkrepo.repository.RemoteRepositoryImpl
import it.wakala.talkrepo.repository.LocalRepositoryImpl
import it.wakala.talkrepo.repository.RemoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource =
        remoteDataSourceImpl

    @Singleton
    @Provides
    fun provideLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource =
        localDataSourceImpl

    @Singleton
    @Provides
    fun provideRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository =
        remoteRepositoryImpl

    @Singleton
    @Provides
    fun provideLocalRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository =
        localRepositoryImpl

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): MarvelDataBase =
        MarvelDataBase.getDatabaseInstance(context)


}