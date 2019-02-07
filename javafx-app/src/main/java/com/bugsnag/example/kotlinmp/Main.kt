package com.bugsnag.example.kotlinmp

import com.bugsnag.Bugsnag
import javafx.application.Application
import javafx.stage.Stage

class Main : Application() {

    override fun start(primaryStage: Stage) {
        Bugsnag("your-api-key")
        launchApp(primaryStage, Main::class.java.classLoader)
    }

    companion object {
        @JvmStatic
        fun main() {
            Application.launch(Main::class.java)
        }
    }
}
