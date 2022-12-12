package com.aib.assessment.feature.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aib.assessment.R
import com.aib.assessment.databinding.FragmentWeatherDetailsBottomsheetBinding
import com.aib.assessment.utils.ParameterConstants
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * To shown detailed Weather info use bottom sheet dialog fragment.
 */
class WeatherDetailsBottomSheetFragment: BottomSheetDialogFragment() {

    private var _detailsBinding: FragmentWeatherDetailsBottomsheetBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _detailsBinding =
            FragmentWeatherDetailsBottomsheetBinding.inflate(inflater, container, false)
        return _detailsBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpData()
    }

    private fun setUpData() {
        _detailsBinding?.apply {
            arguments?.apply {
                weatherDetailsCityName.text = getString(ParameterConstants.CITY_NAME)
                weatherDetailsDate.text = getString(ParameterConstants.DATE_TEXT)
                weatherDetailsTemperature.text = String.format(getString(R.string.temp_details_large), getString(ParameterConstants.TEMPERATURE))
                weatherDetailsHumidity.text = String.format(getString(R.string.humidity), getString(ParameterConstants.HUMIDITY))
                weatherDetailsPressure.text = String.format(getString(R.string.pressure), getString(ParameterConstants.PRESSURE))
                weatherDetailsTempMax.text = String.format(getString(R.string.temperature_max), getString(ParameterConstants.TEMP_MAX))
                weatherDetailsTempMin.text = String.format(getString(R.string.temperature_min), getString(ParameterConstants.TEMP_MIN))
                Glide.with(requireContext()).load(getString(ParameterConstants.IMAGE_URL)).into(weatherImage)
            }
        }
    }
}