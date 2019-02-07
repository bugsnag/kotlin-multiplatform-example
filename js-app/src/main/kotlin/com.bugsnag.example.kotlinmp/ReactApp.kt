package com.bugsnag.example.kotlinmp

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.setState

interface AppState : RState {
    var languages: List<LanguageFact>
    var message: String
}

private class App : RComponent<RProps, AppState>() {

    override fun componentWillMount() {
        setState {
            languages = LanguageFactRepository().fetchLanguageFacts()
            message = platformMessage()
        }
    }

    override fun RBuilder.render() {
        div("mdc-layout-grid") {
            div("mdc-layout-grid__inner") {
                div("mdc-layout-grid__cell mdc-layout-grid__cell") {
                    h2 {
                        +state.message
                    }
                    languageList(state.languages) {
                        setState {
                            this.message = it.description
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {
}
