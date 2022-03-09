package it.wakala.talkrepo.usecase

import it.wakala.talkrepo.base.UseCase
import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.repositories.LocalRepository
import it.wakala.talkrepo.repositories.RemoteRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val localRepository: LocalRepository
) : UseCase<LoginUseCase.Params, LoginEntity> {

    override suspend fun execute(param: Params): LoginEntity {
        return localRepository.login(param.name, param.surname)
    }

    data class Params(val name: String, val surname: String)

}