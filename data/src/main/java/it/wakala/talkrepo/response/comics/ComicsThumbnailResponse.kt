package it.wakala.talkrepo.response.comics

import com.squareup.moshi.Json
import java.io.Serializable

class ComicsThumbnailResponse : Serializable {

    @Json(name = "path")
    var path: String? = null

    @Json(name = "extension")
    var extension: String? = null

}