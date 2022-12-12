package com.aib.assessment.feature.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.aib.assessment.R
import com.aib.assessment.databinding.FragmentWeatherListBinding
import com.aib.assessment.feature.model.data_class.WeatherDataResponse
import com.aib.assessment.feature.viewmodel.WeatherListViewModel
import com.aib.assessment.network.Resource
import com.aib.assessment.utils.ParameterConstants
import com.aib.assessment.utils.convertTimestampToDateTimeString
import com.aib.assessment.utils.kelvinToCelsius
import kotlinx.coroutines.flow.collectLatest

/**
 * A WeatherListFragment class is to display list of Weather report for 5 days.
 */
class WeatherListFragment : Fragment() {

    private var _binding: FragmentWeatherListBinding? = null
    private lateinit var _weatherListAdapter: WeatherListAdapter
    private val weatherListViewModel: WeatherListViewModel by viewModels {
        defaultViewModelProviderFactory
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        getWeatherData()
    }

    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            weatherListViewModel.weatherListFlow.collectLatest {
                if (it != null) {
                    when (it) {
                        is Resource.Loading -> {
                            handleProgressbarUI(false)
                        }
                        is Resource.Error -> {
                            handleProgressbarUI()
                        }
                        is Resource.Success -> {
                            handleProgressbarUI()
                            processResponse(it)
                        }
                    }
                }
            }
        }
    }

    private fun processResponse(it: Resource.Success<WeatherDataResponse>) {
        //Log.d("*Resp*", "response : ${it.data.toString()}")
        setWeatherListAdapter(it.data)
    }

    private fun getWeatherData() {
        weatherListViewModel.getWeatherDetails()
    }

    private fun setWeatherListAdapter(data: WeatherDataResponse?) {
        _weatherListAdapter = WeatherListAdapter(requireContext(), data)
        _binding?.weatherList?.adapter = _weatherListAdapter
        _weatherListAdapter.setOnItemClickListener(object : WeatherListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, data: WeatherDataResponse?) {
                val itemData = data?.list?.get(position)
                val bundleData = Bundle().apply {
                    putString(
                        ParameterConstants.CITY_NAME,
                        "${data?.city?.name}, ${data?.city?.country}"
                    )
                    putString(
                        ParameterConstants.DATE_TEXT,
                        itemData?.dt?.convertTimestampToDateTimeString()
                    )
                    putString(
                        ParameterConstants.TEMPERATURE,
                        itemData?.main?.temp?.kelvinToCelsius().toString()
                    )
                    putString(
                        ParameterConstants.HUMIDITY,
                        itemData?.main?.humidity.toString()
                    )
                    putString(
                        ParameterConstants.PRESSURE,
                        itemData?.main?.pressure.toString()
                    )
                    putString(
                        ParameterConstants.TEMP_MIN,
                        itemData?.main?.tempMin.toString()
                    )
                    putString(
                        ParameterConstants.TEMP_MAX,
                        itemData?.main?.tempMax.toString()
                    )
                    putString(
                        ParameterConstants.IMAGE_URL,
                        "http://openweathermap.org/img/w/${itemData?.weather?.get(0)?.icon}.png"
                    )
                }
                findNavController().navigate(
                    R.id.action_weatherListFragment_to_weatherDetailsBottomSheetFragment,
                    bundleData
                )
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleProgressbarUI(hideProgressbar: Boolean = true) {
        binding.weatherProgressbar.visibility = if (hideProgressbar) View.GONE else View.VISIBLE
        binding.group.visibility = if (hideProgressbar) View.VISIBLE else View.GONE
    }
}