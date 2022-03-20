package it.wakala.talkrepo.response.comics

import com.squareup.moshi.Json
import java.io.Serializable

class ComicsResponse : Serializable {

    @Json(name = "data")
    var data: ComicsDataResponse? = null

}