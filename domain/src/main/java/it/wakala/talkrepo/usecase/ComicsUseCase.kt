package it.wakala.talkrepo.usecase

import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.database.ComicsTable
import it.wakala.talkrepo.extension.toComicsTableList
import it.wakala.talkrepo.repository.ComicsRepository
import javax.inject.Inject

class ComicsUseCase @Inject constructor(private var comicsRepository: ComicsRepository) :
    UseCase<Int, ArrayList<ComicsTable>> {

    override suspend fun execute(param: Int): ArrayList<ComicsTable> {
        val comicsEntity = comicsRepository.fetchComics(param)
        val comicsTableList = comicsEntity.toComicsTableList()
        for(comicsTable in comicsTableList){
            comicsRepository.insertComics(comicsTable)
        }
        return comicsTableList
    }

}