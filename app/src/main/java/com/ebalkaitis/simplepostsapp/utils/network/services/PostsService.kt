package com.ebalkaitis.simplepostsapp.utils.network.services

import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostsService {
    @GET("/posts")
    fun getPosts(): Single<List<Post>>
}
