package com.aib.assessment.feature.model.data_class

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataResponse(
    @SerialName("cod")
    var `cod`: String? = null,
    @SerialName("message")
    var `message`: Int? = null,
    @SerialName("cnt")
    var `cnt`: Int? = null,
    @SerialName("list")
    var `list`: ArrayList<List> = arrayListOf(),
    @SerialName("city")
    var `city`: City? = City()
)
