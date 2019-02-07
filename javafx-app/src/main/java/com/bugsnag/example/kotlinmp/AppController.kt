package com.bugsnag.example.kotlinmp

import javafx.scene.control.Label
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.ScrollPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.Region

class AppController {

    lateinit var rootPane: HBox
    lateinit var detailView: ScrollPane
    lateinit var detailLabel: Label
    lateinit var listView: ListView<LanguageFact>

    fun initialize() {
        adjustLayoutWidthToMax(listView, detailView)

        listView.setCellFactory {
            object : ListCell<LanguageFact>() {
                override fun updateItem(item: LanguageFact?, empty: Boolean) {
                    super.updateItem(item, empty)
                    text = item?.name
                }
            }
        }

        val languageFacts = LanguageFactRepository().fetchLanguageFacts()
        listView.items.addAll(languageFacts)
        listView.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
            detailLabel.text = newValue.description
        }

        // add an initial selection
        listView.selectionModel.select(0)
    }

    private fun adjustLayoutWidthToMax(vararg views: Region) {
        views.forEach {
            it.maxWidth = Double.MAX_VALUE
            HBox.setHgrow(it, Priority.ALWAYS)
        }
    }
}
