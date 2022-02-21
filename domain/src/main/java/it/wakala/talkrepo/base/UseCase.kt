package base

interface UseCase<K, T> {

    fun execute(param: K): T

}