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
        launchJob {
            model.fetchPosts()
                .observeOn(scheduler)
                .subscribe({ posts ->
                    onView { populatePosts(posts) }
                }, Timber::e)
        }
    }
}
