package com.bugsnag.example.kotlinmp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LanguageFactController {
    private val facts = LanguageFactRepository().fetchLanguageFacts()

    @GetMapping("languages")
    fun fetchLanguageFacts() = facts

    @GetMapping("languages/{name}")
    fun fetchLanguageFact(@PathVariable name: String) = facts.singleOrNull { it.name.equals(name, true) }
}
