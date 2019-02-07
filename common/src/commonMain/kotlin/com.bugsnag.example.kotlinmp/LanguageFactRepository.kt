package com.bugsnag.example.kotlinmp

class LanguageFactRepository {
    fun fetchLanguageFacts() = listOf(
        LanguageFact("C", "The spiritual inspiration of most programming languages"),
        LanguageFact("Java", "The predecessor to Kotlin"),
        LanguageFact("Kotlin", "A modern programming language that runs on multiple platforms"),
        LanguageFact("JavaScript", "Widely used in the browser"),
        LanguageFact("Python", "An interpreted language with lots of imports"),
        LanguageFact("C#", "A language which runs on the .NET runtime"),
        LanguageFact("PHP", "Typically used in server environments"),
        LanguageFact("Ruby", "Commonly used in the popular Ruby on Rails framework"),
        LanguageFact("Swift", "A modern programming language that runs on Apple devices"),
        LanguageFact("Objective-C", "A super-set of C which adds lots of square brackets"),
        LanguageFact("Go", "A modern programming language that is very fast and commonly used in microservices")
    ).sortedBy(LanguageFact::name)
}
