package com.shivaraj.kotlinforandroiddevelopers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.shivaraj.kotlinforandroiddevelopers.adapters.ForecastListAdapter
import com.shivaraj.kotlinforandroiddevelopers.domain.commands.RequestForecastCommand
import com.shivaraj.kotlinforandroiddevelopers.domain.model.Forecast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result) {toast(it.date) }
            }
        }
    }
}
