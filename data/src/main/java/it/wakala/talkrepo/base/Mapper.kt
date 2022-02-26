package it.wakala.talkrepo.base

abstract class Mapper<T, K, P>(params: P? = null) {

    abstract fun mapToEntity(input: T): K

}