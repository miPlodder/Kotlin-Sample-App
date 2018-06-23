package com.example.saksham.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var mainAdapter : MainAdapter? = null
    var list : ArrayList<Row> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add(Row("1", "one"))
        list.add(Row("2", "two"))
        list.add(Row("3", "three"))
        list.add(Row("4", "four"))
        list.add(Row("5", "five"))

        mainAdapter = MainAdapter(this, list)
        rvList.adapter = mainAdapter
        rvList.layoutManager = LinearLayoutManager(this)

    }
}
