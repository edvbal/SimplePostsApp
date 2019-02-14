package com.ebalkaitis.simplepostsapp.utils.network.services

import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.entities.User
import io.reactivex.Single
import retrofit2.http.GET

interface UsersService {
    @GET("/users")
    fun getUsers(): Single<List<User>>
}
