package com.aib.assessment.feature.model.data_class

import com.aib.assessment.feature.model.data_class.Coord
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class City(
    @SerialName("id")
    var `id`: Int? = null,
    @SerialName("name")
    var `name`: String? = null,
    @SerialName("coord")
    var `coord`: Coord? = Coord(),
    @SerialName("country")
    var `country`: String? = null,
    @SerialName("population")
    var `population`: Int? = null,
    @SerialName("timezone")
    var `timezone`: Int? = null,
    @SerialName("sunrise")
    var `sunrise`: Int? = null,
    @SerialName("sunset")
    var `sunset`: Int? = null
)
