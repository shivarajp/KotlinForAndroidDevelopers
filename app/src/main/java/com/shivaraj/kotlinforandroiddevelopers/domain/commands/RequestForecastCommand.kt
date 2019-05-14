package com.shivaraj.kotlinforandroiddevelopers.domain.commands

import com.shivaraj.kotlinforandroiddevelopers.data.ForecastRequest
import com.shivaraj.kotlinforandroiddevelopers.domain.Command
import com.shivaraj.kotlinforandroiddevelopers.domain.Mappers.ForecastDataMapper
import com.shivaraj.kotlinforandroiddevelopers.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) :
    Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
            forecastRequest.execute()
        )
    }
}