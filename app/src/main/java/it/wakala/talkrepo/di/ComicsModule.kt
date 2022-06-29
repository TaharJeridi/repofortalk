package it.wakala.talkrepo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.usecase.ComicsUseCase
import it.wakala.talkrepo.api.IComicsAPI
import it.wakala.talkrepo.database.MarvelDataBase
import it.wakala.talkrepo.datasource.ComicsLocalDataSource
import it.wakala.talkrepo.datasource.ComicsLocalDataSourceImpl
import it.wakala.talkrepo.datasource.ComicsRemoteDataSource
import it.wakala.talkrepo.datasource.ComicsRemoteDataSourceImpl
import it.wakala.talkrepo.repository.ComicsRepository
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
    fun provideComicsLocalDataSource(marvelDataBase: MarvelDataBase): ComicsLocalDataSource {
        return ComicsLocalDataSourceImpl(marvelDataBase)
    }

    @Provides
    @Singleton
    fun provideComicsRepository(
        comicsRemoteDataSource: ComicsRemoteDataSource,
        comicsLocalDataSource: ComicsLocalDataSource
    ): ComicsRepository {
        return ComicsRepositoryImpl(comicsRemoteDataSource, comicsLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideComicsUseCase(comicsRepository: ComicsRepository): ComicsUseCase {
        return ComicsUseCase(comicsRepository)
    }

}