package com.bugsnag.example.kotlinmp

import react.dom.render
import kotlin.browser.document

fun main() {
    document.addEventListener("DOMContentLoaded", {
        render(document.getElementById("root")) {
            app()
        }
    })
}
