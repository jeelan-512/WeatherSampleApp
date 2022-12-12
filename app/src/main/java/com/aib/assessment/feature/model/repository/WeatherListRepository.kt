package com.aib.assessment.feature.model.repository

import com.aib.assessment.feature.model.data_class.WeatherDataResponse
import com.aib.assessment.network.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherListRepository {
    suspend fun getWeatherListData(
        latitude: String?,
        longitude: String?
    ): Flow<Resource<WeatherDataResponse>>
}