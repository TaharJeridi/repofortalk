package it.wakala.talkrepo

import it.wakala.talkrepo.repositories.IRepository

class RepositoryContainer {

    var mapRepo:HashMap<String, IRepository> = HashMap()

    fun saveRepository(key: String, repository: IRepository) {
        if (!mapRepo.containsKey(key)) {
            mapRepo[key] = repository
        }
    }

    fun getRepository(key: String): IRepository? {
        return mapRepo[key]
    }

    fun removeRemo(key: String) {
        mapRepo.remove(key)
    }
}