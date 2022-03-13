package it.wakala.talkrepo.di.comics

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.base.comics.ComicsUseCase
import repositories.comics.ComicsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ComicsModule {

    @Provides
    @Singleton
    fun provideComicsUseCase(): ComicsUseCase {
        return ComicsUseCase(ComicsRepository())
    }

}