package com.codingmart.coffeapp.Retrofit

import com.codingmart.coffeapp.Coffee
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("hot")
     fun getData(): Call<List<Coffee>>
}