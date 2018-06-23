package com.example.saksham.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var mainAdapter : MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainAdapter = MainAdapter(this, ArrayList())
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = mainAdapter

        var retrofitService : Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        var service : RetrofitService = retrofitService.create(RetrofitService::class.java)

        service.getPosts().enqueue(object : Callback<ArrayList<Row>> {
            override fun onFailure(call: Call<ArrayList<Row>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ArrayList<Row>>?, response: Response<ArrayList<Row>>?) {
                mainAdapter!!.list = response!!.body()
                mainAdapter!!.notifyDataSetChanged()
            }
        })
    }
}