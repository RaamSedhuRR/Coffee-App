package com.codingmart.coffeapp

import com.google.gson.annotations.SerializedName

class Coffee  {
    @SerializedName("title")
    var title:String? = null
    @SerializedName("description")
    var description:String? = null;
    @SerializedName("image")
    var image:String? = null

}