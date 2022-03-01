package it.wakala.talkrepo.base

interface UseCase<K, T> {

    suspend fun execute(param: K): T

}