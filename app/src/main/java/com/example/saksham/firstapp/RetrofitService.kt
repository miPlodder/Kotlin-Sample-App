package com.example.saksham.firstapp

import retrofit2.Call
import retrofit2.http.GET


/*
 * Created by saksham on 23/June/2018
*/

interface RetrofitService {

    @GET("posts/")
    fun getPosts() : Call<ArrayList<Row>>

}