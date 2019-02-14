package com.ebalkaitis.simplepostsapp.posts.fragment.mvp

import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsContract
import com.ebalkaitis.simplepostsapp.utils.mvp.ViewPresenter
import io.reactivex.Scheduler
import timber.log.Timber

class PostsPresenter(
    private val model: PostsContract.Model,
    private val scheduler: Scheduler
) : PostsContract.Presenter,
    ViewPresenter<PostsContract.View>() {
    override fun onCreated() {
        onView { setRecyclerView() }
        launchJob {
            model.fetchComments()
                .flatMap { comments ->
                    model.saveComments(comments)
                    model.fetchUsers()
                }
                .flatMap { users ->
                    model.saveUsers(users)
                    model.fetchPosts()
                }
                .observeOn(scheduler)
                .subscribe({ posts ->
                    onView { populatePosts(posts) }
                }, Timber::e)
        }
    }
}
