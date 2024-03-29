package com.shivaraj.kotlinforandroiddevelopers

import android.app.Application
import com.shivaraj.kotlinforandroiddevelopers.ui.utils.DelegatesExt

class App : Application(){

    companion object{
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}