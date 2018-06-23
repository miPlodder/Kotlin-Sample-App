package com.example.saksham.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        var service : RetrofitService = retrofitService.create(RetrofitService::class.java)

        service.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ArrayList<Row>>() {

                    override fun onComplete() {

                    }

                    override fun onNext(t: ArrayList<Row>) {
                        mainAdapter!!.list = t
                        mainAdapter!!.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }
}