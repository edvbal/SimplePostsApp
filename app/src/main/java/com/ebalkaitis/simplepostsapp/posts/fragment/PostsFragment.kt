package com.ebalkaitis.simplepostsapp.posts.fragment

import android.os.Bundle
import android.view.View
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerFragment
import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsContract
import com.ebalkaitis.simplepostsapp.utils.network.responses.Post
import javax.inject.Inject

class PostsFragment : BaseDaggerFragment(), PostsContract.View {
    override fun populatePosts(posts: List<Post>) {
        // empty
    }

    @Inject
    lateinit var presenter: PostsContract.Presenter

    override fun getLayoutId() = R.layout.fragment_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.takeView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreated()
    }

    override fun onDestroyView() {
        presenter.dropView()
        super.onDestroyView()
    }

    companion object {
        fun newInstance(): PostsFragment {
            return PostsFragment()
        }
    }
}
