package it.wakala.talkrepo.base.comics

import it.wakala.talkrepo.base.UseCase
import repositories.comics.ComicsRepository
import javax.inject.Inject

class ComicsUseCase @Inject constructor(private var comicsRepository: ComicsRepository) :
    UseCase<Any?, Any?> {

    override suspend fun execute(param: Any?): Any? {
        return comicsRepository.fetchAny()
    }

}