package com.example.saksham.firstapp

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET


/*
 * Created by saksham on 23/June/2018
*/

interface RetrofitService {

    @GET("posts/")
    fun getPosts() : Observable<ArrayList<Row>>

}