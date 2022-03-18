package it.wakala.talkrepo.usecase

import it.wakala.talkrepo.repositories.ComicsRepository
import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.comics.ComicsEntity
import javax.inject.Inject

class ComicsUseCase @Inject constructor(private var comicsRepository: ComicsRepository) :
    UseCase<Any?, ArrayList<ComicsEntity>> {

    override suspend fun execute(param: Any?): ArrayList<ComicsEntity> {
        return comicsRepository.fetchComics()
    }

}