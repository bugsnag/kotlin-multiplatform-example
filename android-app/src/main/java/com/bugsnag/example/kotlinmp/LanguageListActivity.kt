package com.bugsnag.example.kotlinmp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bugsnag.example.kotlinmp.R
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_language_list.listRecyclerView

class LanguageListActivity : AppCompatActivity() {

    private lateinit var adapter: LanguageListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_list)
        title = platformMessage()

        val languageFacts = LanguageFactRepository().fetchLanguageFacts()

        adapter = LanguageListAdapter(languageFacts, View.OnClickListener {
            val position = listRecyclerView!!.getChildAdapterPosition(it)
            val item = adapter.getItem(position)
            Toast.makeText(this, item.description, Toast.LENGTH_LONG).show()
        })
        listRecyclerView.layoutManager = LinearLayoutManager(this)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        listRecyclerView.addItemDecoration(decoration)
    }

}
