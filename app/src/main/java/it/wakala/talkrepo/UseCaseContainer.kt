package it.wakala.talkrepo

import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.base.comics.ComicsUseCase
import repositories.comics.ComicsRepository

class UseCaseContainer {

    var mapUseCase:HashMap<String,UseCase<*,*>> = HashMap<String, UseCase<*,*>>().apply {
        put(ComicsUseCase::class.java.name,ComicsUseCase(ComicsRepository()))
    }

    fun saveUseCase(key: String, useCase:UseCase<*,*>) {
        if (!mapUseCase.containsKey(key)) {
            mapUseCase[key] = useCase
        }
    }

    fun getUseCase(key: String): UseCase<*,*>? {
        return mapUseCase[key]
    }

    fun removeUseCase(key: String) {
        mapUseCase.remove(key)
    }
}