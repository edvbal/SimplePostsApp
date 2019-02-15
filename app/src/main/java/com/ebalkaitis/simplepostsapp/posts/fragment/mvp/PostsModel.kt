package com.ebalkaitis.simplepostsapp.posts.fragment.mvp

import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails
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
    private val posts: MutableList<Post> = mutableListOf()

    override fun saveUsers(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)
    }

    override fun saveComments(comments: List<Comment>) {
        this.comments.clear()
        this.comments.addAll(comments)
    }

    override fun fetchComments(): Single<List<Comment>> = commentsService.getComments()

    override fun fetchUsers(): Single<List<User>> = usersService.getUsers()

    override fun fetchPosts(): Single<List<Post>> = postsService.getPosts()

    override fun getPostDetails(post: Post): PostDetails {
        val postTitle = findPostTitle(post)
        val postBody = findPostBody(post)
        val postUsername = findPostUsername(post)
        val numberOfComments = findNumberOfComments(post)
        return PostDetails(postTitle, postBody, postUsername, numberOfComments)
    }

    private fun findPostTitle(post: Post): String {
        posts.find { savedPost -> savedPost.id == post.id }?.let { foundPost ->
            return foundPost.title
        } ?: return ""
    }

    private fun findPostUsername(post: Post): String {
        users.find { savedUser -> savedUser.id == post.userId }?.let { foundUser ->
            return foundUser.username
        } ?: return ""
    }

    private fun findNumberOfComments(
        post: Post
    ): Int = comments.count { savedComment -> savedComment.postId == post.id }

    private fun findPostBody(post: Post): String {
        posts.find { savedPost -> savedPost.id == post.id }?.let { foundPost ->
            return foundPost.body
        } ?: return ""
    }

    override fun savePosts(posts: List<Post>) {
        this.posts.clear()
        this.posts.addAll(posts)
    }
}
