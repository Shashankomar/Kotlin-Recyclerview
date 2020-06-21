package com.example.kotlindemomvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView(getData())
    }

    private fun setRecyclerView(data: ArrayList<String>) {
        rv_main.adapter = MainDataAdapter(this, data)
        rv_main.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
    }

    private fun getData(): ArrayList<String> {
        return ArrayList<String>().apply {
            add("item 1")
            add("item 2")
            add("item 3")
            add("item 4")
            add("item 5")
            add("item 6")
            add("item 7")
            add("item 8")
            add("item 9")
            add("item 10")
            add("item 11")
            add("item 12")
        }
    }
}
