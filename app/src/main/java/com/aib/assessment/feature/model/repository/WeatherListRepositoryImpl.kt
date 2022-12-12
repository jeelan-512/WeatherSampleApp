package com.aib.assessment.feature.model.repository

import android.util.Log
import com.aib.assessment.feature.model.data_class.WeatherDataResponse
import com.aib.assessment.network.ApiService
import com.aib.assessment.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class WeatherListRepositoryImpl(private val apiService: ApiService) : WeatherListRepository {
    override suspend fun getWeatherListData(
        latitude: String?,
        longitude: String?
    ): Flow<Resource<WeatherDataResponse>> = flow {
        try {
            emit(
                Resource.Success(
                    apiService.getWeatherList(latitude, longitude)
                )
            )
        } catch (exception: Exception) {
            try {
                emit(Resource.Error(message = exception.message ?: ""))
                Log.e("Weather error", exception.message.toString())
            } catch (exception: java.lang.Exception) {
            }
        }
    }
}