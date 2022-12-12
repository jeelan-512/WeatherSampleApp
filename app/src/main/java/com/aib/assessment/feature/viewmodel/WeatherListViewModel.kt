package com.aib.assessment.feature.viewmodel

import androidx.lifecycle.viewModelScope
import com.aib.assessment.feature.model.data_class.WeatherDataResponse
import com.aib.assessment.feature.model.repository.WeatherListRepositoryImpl
import com.aib.assessment.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Weather list view model.
 *
 * @constructor Create empty constructor for weather list view model
 */
class WeatherListViewModel : BaseViewModel() {
    private var _weatherListFlow = MutableStateFlow<Resource<WeatherDataResponse>?>(null)
    val weatherListFlow get() = _weatherListFlow
    private val weatherListRepositoryImpl by lazy {
        WeatherListRepositoryImpl(client)
    }

    fun getWeatherDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            weatherListRepositoryImpl.getWeatherListData("13.082680", "80.270721").collectLatest {
                _weatherListFlow.value = it
            }
        }
    }
}
