package com.ebalkaitis.simplepostsapp.posts.fragment.mvp

import com.ebalkaitis.simplepostsapp.utils.network.responses.Post
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import io.reactivex.Single

class PostsModel(private val postsService: PostsService) :
    PostsContract.Model {
    override fun fetchPosts(): Single<List<Post>> = postsService.getPosts()
}
