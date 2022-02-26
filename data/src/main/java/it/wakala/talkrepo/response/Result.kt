package it.wakala.talkrepo.response

data class Result(
    val description: String,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)