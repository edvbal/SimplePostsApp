package com.ebalkaitis.simplepostsapp.posts.fragment.mvp

import com.ebalkaitis.simplepostsapp.utils.network.entities.Comment
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.entities.User
import com.ebalkaitis.simplepostsapp.utils.network.services.CommentsService
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import com.ebalkaitis.simplepostsapp.utils.network.services.UsersService
import io.reactivex.Single

class PostsModel(
    private val postsService: PostsService,
    private val usersService: UsersService,
    private val commentsService: CommentsService
) : PostsContract.Model {

    private val users: MutableList<User> = mutableListOf()
    private val comments: MutableList<Comment> = mutableListOf()

    override fun saveUsers(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
    }

    override fun getUsers() = users

    override fun saveComments(comments: List<Comment>) {
        this.comments.clear()
        this.comments.addAll(comments)
    }

    override fun getComments() = comments

    override fun fetchComments(): Single<List<Comment>> = commentsService.getComments()

    override fun fetchUsers(): Single<List<User>> = usersService.getUsers()

    override fun fetchPosts(): Single<List<Post>> = postsService.getPosts()
}
