package com.aib.assessment.network

import com.aib.assessment.feature.model.data_class.error.ErrorApiResponse

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val errorData: ErrorApiResponse? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null, errorData: ErrorApiResponse? = null) :
        Resource<T>(data, message, errorData)

    class Loading<T>(data: T? = null) : Resource<T>(data)
}