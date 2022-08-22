package com.codingmart.coffeapp
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingmart.coffeapp.databinding.ActivityMainItemBinding

class CoffeeAdapter( val coffeeDataList : List<Coffee> ,val context : Context
) : RecyclerView.Adapter<CoffeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoffeeViewHolder(
            ActivityMainItemBinding
            .inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bindView(
            coffeeDataList[position].title
            , coffeeDataList[position].description,
            coffeeDataList[position].image,
            context
        )
    }

    override fun getItemCount(): Int {
        return coffeeDataList.size
    }


}