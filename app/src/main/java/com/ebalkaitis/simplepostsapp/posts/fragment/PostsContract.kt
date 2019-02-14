package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.utils.mvp.BasePresenter
import com.ebalkaitis.simplepostsapp.utils.network.responses.Post
import io.reactivex.Single

interface PostsContract {
    interface Model {
        fun fetchPosts(): Single<List<Post>>
    }

    interface View {
        fun populatePosts(posts: List<Post>)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}
