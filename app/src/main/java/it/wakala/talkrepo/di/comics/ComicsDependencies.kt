package it.wakala.talkrepo.di.comics

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.base.comics.ComicsUseCase

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ComicsDependencies {

    fun provideComicsUseCase(): ComicsUseCase

}