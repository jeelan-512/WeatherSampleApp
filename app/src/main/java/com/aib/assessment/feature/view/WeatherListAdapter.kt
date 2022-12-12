package com.aib.assessment.feature.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aib.assessment.R
import com.aib.assessment.databinding.WeatherListItemBinding
import com.aib.assessment.feature.model.data_class.WeatherDataResponse
import com.aib.assessment.utils.convertTimestampToDateTimeString
import com.aib.assessment.utils.kelvinToCelsius
import com.bumptech.glide.Glide

/**
 * Adapter class for weather list recycler view
 * @property context
 * @property data
 * @constructor Create [WeatherListAdapter]
 */
class WeatherListAdapter(private val context: Context, val data: WeatherDataResponse?) :
    RecyclerView.Adapter<WeatherListAdapter.WeatherListViewHolder>() {

    private lateinit var _listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        val binding =
            WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherListViewHolder(binding, _listener, data)
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        val itemData = data?.list?.get(position)
        holder.binding.apply {
            weatherCityName.text = "${data?.city?.name}, ${data?.city?.country}"
            weatherStatus.text = String.format(
                context.getString(R.string.temperature),
                itemData?.main?.temp?.kelvinToCelsius().toString()
            )
            weatherDate.text = itemData?.dt?.convertTimestampToDateTimeString()
            weatherRange.text = String.format(
                context.getString(R.string.temp_details),
                itemData?.main?.humidity.toString(),
                itemData?.main?.pressure.toString()
            )
            Glide.with(context)
                .load("http://openweathermap.org/img/w/${itemData?.weather?.get(0)?.icon}.png")
                .placeholder(context.getDrawable(androidx.appcompat.R.drawable.abc_btn_default_mtrl_shape))
                .into(weatherImage)
        }
    }

    override fun getItemCount(): Int {
        return data?.list?.size ?: 0
    }

    class WeatherListViewHolder(
        val binding: WeatherListItemBinding,
        listener: OnItemClickListener,
        data: WeatherDataResponse?
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition, data)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, data: WeatherDataResponse?)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        _listener = listener
    }
}