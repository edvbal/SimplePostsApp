package com.ebalkaitis.simplepostsapp.utils.network.entities

import com.google.gson.annotations.SerializedName

data class Company(val name: String, val catchPhrase: String, @SerializedName("bs") val businessType: String)

