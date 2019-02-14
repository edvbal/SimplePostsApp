package com.ebalkaitis.simplepostsapp.utils.network.services

import com.ebalkaitis.simplepostsapp.utils.network.entities.Comment
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import io.reactivex.Single
import retrofit2.http.GET

interface CommentsService {
    @GET("/comments")
    fun getComments(): Single<List<Comment>>
}
