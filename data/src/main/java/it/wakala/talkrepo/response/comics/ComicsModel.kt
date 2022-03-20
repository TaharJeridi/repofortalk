package it.wakala.talkrepo.response.comics

import com.squareup.moshi.Json
import java.io.Serializable

class ComicsModel:Serializable {

    @Json(name = "id")
    var id:Int? = null

    @Json(name = "digitalId")
    var digitalId:Int? = null

    @Json(name = "title")
    var title:String? = null

    @Json(name = "variantDescription")
    var variantDescription:String? = null

    @Json(name = "description")
    var description:String? = null

    @Json(name = "pageCount")
    var pageCount:Int? = null

    @Json(name = "resourceURI")
    var resourceURI:String? = null

    @Json(name = "thumbnail")
    var thumbnail:ComicsThumbnailResponse? = null

}