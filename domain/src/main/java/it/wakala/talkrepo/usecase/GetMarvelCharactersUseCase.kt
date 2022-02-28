package it.wakala.talkrepo.usecase

import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.repositories.RemoteRepository
import javax.inject.Inject

class GetMarvelCharactersUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
) : UseCase<GetMarvelCharactersUseCase.Params, MarvelCharsEntity> {

    override suspend fun execute(param: Params): MarvelCharsEntity {
        return remoteRepository.getAllCharacters()
    }

    class Params

}