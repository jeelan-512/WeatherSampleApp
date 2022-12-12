package com.aib.assessment.feature.model.data_class.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorApiResponse(
    @SerialName("error")
    val error: String?
)