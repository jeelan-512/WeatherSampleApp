package com.aib.assessment.feature.model.data_class

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    @SerialName("3h")
    var `3h`: Double? = null
)

