package it.wakala.talkrepo.response.comics

import com.squareup.moshi.Json
import java.io.Serializable

class ComicsDataResponse : Serializable {

    @Json(name = "results")
    var results: List<ComicsModel>? = null

}