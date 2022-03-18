package it.wakala.talkrepo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.repositories.ComicsRepository
import it.wakala.talkrepo.usecase.ComicsUseCase
import it.wakala.talkrepo.api.IComicsAPI
import it.wakala.talkrepo.datasource.ComicsRemoteDataSource
import it.wakala.talkrepo.datasource.ComicsRemoteDataSourceImpl
import it.wakala.talkrepo.repository.ComicsRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ComicsModule {

    @Provides
    @Singleton
    fun provideComicsRemoteDataSource(retrofit: Retrofit): ComicsRemoteDataSource {
        return ComicsRemoteDataSourceImpl(retrofit.create(IComicsAPI::class.java))
    }

    @Provides
    @Singleton
    fun provideComicsRepository(comicsRemoteDataSource: ComicsRemoteDataSource): ComicsRepository {
        return ComicsRepositoryImpl(comicsRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideComicsUseCase(comicsRepository: ComicsRepository): ComicsUseCase {
        return ComicsUseCase(comicsRepository)
    }

}