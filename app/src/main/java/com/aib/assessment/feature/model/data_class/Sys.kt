package com.aib.assessment.feature.model.data_class

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName("pod")
    var `pod`: String? = null
)
