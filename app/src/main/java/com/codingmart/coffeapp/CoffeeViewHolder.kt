package com.codingmart.coffeapp

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingmart.coffeapp.databinding.ActivityMainItemBinding

class CoffeeViewHolder(var binding: ActivityMainItemBinding) : RecyclerView.ViewHolder(binding.root)
{
    fun bindView( title: String?,description: String?,image:String?,context:Context){

        binding.title.text = title
        binding.description.text = description
        Glide.with(context).load(image).into(binding.ImageProfile)


    }
}