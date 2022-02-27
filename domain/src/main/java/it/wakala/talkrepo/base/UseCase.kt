package it.wakala.talkrepo.base

interface UseCase<K, T> {

    fun execute(param: K): T

}