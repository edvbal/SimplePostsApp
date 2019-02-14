package com.ebalkaitis.simplepostsapp.utils.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostDetails(
    val title: String,
    val body: String,
    val userName: String,
    val numberOfComments: Int
) : Parcelable
