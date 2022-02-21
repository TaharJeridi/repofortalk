package it.mirco.pokedex.base

interface Mapper<T, K, P> {

    fun mapToEntity(input: T, params: P? = null): K

}