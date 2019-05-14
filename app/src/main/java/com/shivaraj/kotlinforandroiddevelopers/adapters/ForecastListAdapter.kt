package com.shivaraj.kotlinforandroiddevelopers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shivaraj.kotlinforandroiddevelopers.R
import com.shivaraj.kotlinforandroiddevelopers.domain.model.Forecast
import com.shivaraj.kotlinforandroiddevelopers.domain.model.ForecastList
import com.shivaraj.kotlinforandroiddevelopers.extensions.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast.*

class ForecastListAdapter(private val weakForecast: ForecastList,
                          private val  itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx)
            .inflate(R.layout.item_forecast, parent, false)

        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weakForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weakForecast[position])
    }

    class ViewHolder(override val containerView: View, private val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(containerView), LayoutContainer{


        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(containerView.context).load(iconUrl).into(icon)
                dateText.text = description
                descriptionText.text = description
                maxTemperature.text = "$high"
                minTemperature.text = "$low"
                itemView.setOnClickListener{itemClick(this)}
            }
        }
    }

    interface OnItemClickListener{

        operator fun invoke(forecast: Forecast)
    }
}