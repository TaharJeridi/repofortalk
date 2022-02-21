package it.wakala.talkrepo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.RemoteDataSourceImpl
import it.wakala.talkrepo.datasource.RemoteDataSource
import it.wakala.talkrepo.repository.RemoteRepositoryImpl
import repositories.RemoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource = remoteDataSourceImpl

    @Singleton
    @Provides
    fun provideRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository = remoteRepositoryImpl

}