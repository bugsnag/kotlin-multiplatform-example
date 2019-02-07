package com.bugsnag.example.kotlinmp

import android.app.Application
import com.bugsnag.android.Bugsnag

class ExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Bugsnag.init(this)
    }
}
