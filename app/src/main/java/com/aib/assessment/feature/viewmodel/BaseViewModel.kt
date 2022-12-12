package com.aib.assessment.feature.viewmodel

import androidx.lifecycle.ViewModel
import com.aib.assessment.network.ApiService
import com.aib.assessment.network.repository.BASE_URL
import com.aib.assessment.network.repository.ktorHttpClient

open class BaseViewModel: ViewModel() {
    val client by lazy {
        ApiService(
            client = ktorHttpClient,
            BASE_URL
        )
    }
}