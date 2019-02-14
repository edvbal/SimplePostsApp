package com.ebalkaitis.simplepostsapp.posts.fragment.mvp

import com.ebalkaitis.simplepostsapp.utils.mvp.BasePresenter
import com.ebalkaitis.simplepostsapp.utils.network.responses.Post
import io.reactivex.Single

interface PostsContract {
    interface Model {
        fun fetchPosts(): Single<List<Post>>
    }

    interface View {
        fun populatePosts(posts: List<Post>)
        fun setRecyclerView()
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}
