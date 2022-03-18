package it.wakala.talkrepo.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.wakala.talkrepo.usecase.ComicsUseCase

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ComicsDependencies {

    fun provideComicsUseCase(): ComicsUseCase

}