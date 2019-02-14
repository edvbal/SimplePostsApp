package com.ebalkaitis.simplepostsapp.posts.fragment.mvp

import com.ebalkaitis.simplepostsapp.utils.mvp.BasePresenter
import com.ebalkaitis.simplepostsapp.utils.network.entities.Comment
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.entities.User
import io.reactivex.Single

interface PostsContract {
    interface Model {
        fun fetchComments(): Single<List<Comment>>
        fun fetchPosts(): Single<List<Post>>
        fun fetchUsers(): Single<List<User>>
        fun getUsers(): MutableList<User>
        fun saveUsers(users: List<User>)
        fun saveComments(comments: List<Comment>)
        fun getComments(): MutableList<Comment>
    }

    interface View {
        fun populatePosts(posts: List<Post>)
        fun setRecyclerView()
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}
