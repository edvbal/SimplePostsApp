package com.ebalkaitis.simplepostsapp.utils.network.entities

import com.google.gson.annotations.SerializedName

data class Geo(@SerializedName("lat") val latitude: Double, @SerializedName("lng") val longitude: Double)
