package com.codingmart.coffeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingmart.coffeapp.Retrofit.ApiInterface
import com.codingmart.coffeapp.Retrofit.RetrofitClient
import com.codingmart.coffeapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val TAG : String = "Retrofit Main Activity"
    lateinit var binding : ActivityMainBinding
    lateinit var adapter: CoffeeAdapter
    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var coffeeDataSet : List<Coffee>  = listOf(Coffee())
        val retrofitResponse = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val call : Call<List<Coffee>> = retrofitResponse.getData()
        call.enqueue(object : Callback<List<Coffee>>{
            override fun onResponse(call: Call<List<Coffee>>, response: Response<List<Coffee>>) {
                Log.e(TAG, "onResponse: ${response.body()!![0].title.toString()}")
                if(response.isSuccessful){
                    Log.e(TAG, "onResponse: Suceess" )
                    adapter  = CoffeeAdapter(response.body()!!,context)
                    binding.recyclerView.layoutManager = LinearLayoutManager(context)
                    binding.recyclerView.adapter = adapter

                }
            }
            override fun onFailure(call: Call<List<Coffee>>, t: Throwable) {
                Log.e(TAG, "onFailure: "+t.localizedMessage )
            }
        })
        Log.e(TAG, "onCreate: "+coffeeDataSet[0].title )


                   }
}