package com.aib.assessment.network

import com.aib.assessment.feature.model.data_class.WeatherDataResponse
import com.aib.assessment.utils.ParameterConstants
import io.ktor.client.*
import io.ktor.client.request.*


class ApiService(private val client: HttpClient, private val BASE_URL: String) {

    suspend fun getWeatherList(latitude: String?, longitude: String?): WeatherDataResponse =
        client.get("$BASE_URL") {
            parameter(ParameterConstants.LATITUDE, latitude)
            parameter(ParameterConstants.LONGITUDE, longitude)
            parameter(ParameterConstants.APP_ID, ParameterConstants.APP_KEY)
        }

}
