package com.aib.assessment.feature.model.data_class

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    @SerialName("id")
    var `id`: Int? = null,
    @SerialName("main")
    var `main`: String? = null,
    @SerialName("description")
    var `description`: String? = null,
    @SerialName("icon")
    var `icon`: String? = null
)
