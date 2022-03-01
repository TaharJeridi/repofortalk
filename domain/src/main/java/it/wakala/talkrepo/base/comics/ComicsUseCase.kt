package it.wakala.talkrepo.base.comics

import it.wakala.talkrepo.base.UseCase
import repositories.comics.ComicsRepository

class ComicsUseCase constructor(private val comicsRepository: ComicsRepository) :
    UseCase<Any?, Any?> {

    override suspend fun execute(param: Any?): Any? {
        return null
    }


}