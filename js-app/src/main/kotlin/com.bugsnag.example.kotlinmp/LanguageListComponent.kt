package com.bugsnag.example.kotlinmp

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.li
import react.dom.span
import react.dom.ul

interface LanguageListProps : RProps {
    var data: List<LanguageFact>
    var block: (LanguageFact) -> Unit
}

class LanguageListComponent : RComponent<LanguageListProps, RState>() {
    override fun RBuilder.render() {
        ul("mdc-list mdc-list--two-line") {
            props.data.forEach { item ->
                li("mdc-list-item") {
                    span("mdc-list-item__text") {
                        span("mdc-list-item__primary-text") { +item.name }
                        span("mdc-list-item__secondary-text") { +item.description }
                    }
                    attrs {
                        onClickFunction = {
                            props.block(item)
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.languageList(data: List<LanguageFact>, block: (LanguageFact) -> Unit) =
    child(LanguageListComponent::class) {
        attrs.data = data
        attrs.block = block
    }
