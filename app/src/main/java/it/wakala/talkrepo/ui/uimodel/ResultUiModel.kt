package it.wakala.talkrepo.ui.uimodel

import it.wakala.talkrepo.entity.ResultEntity

sealed class MarvelCharactersResult(
    open val description: String? = null,
    open val id: Int? = null,
    open val modified: String? = null,
    open val name: String? = null,
    open val resourceURI: String? = null,
    open val thumbnail: ThumbnailUiModel? = null,
    open val urls: List<UrlUiModel>? = null
)

data class ResultUiModel(
    override val description: String,
    override val id: Int,
    override val modified: String,
    override val name: String,
    override val resourceURI: String,
    override val thumbnail: ThumbnailUiModel,
    override val urls: List<UrlUiModel>
): MarvelCharactersResult(description, id, modified, name, resourceURI, thumbnail, urls)

object ResultLoadingUiModel: MarvelCharactersResult()

fun ResultEntity.toUiModel() = ResultUiModel(description, id, modified, name, resourceURI, thumbnail.toUiModel(), urls.map { it.toUiModel() })