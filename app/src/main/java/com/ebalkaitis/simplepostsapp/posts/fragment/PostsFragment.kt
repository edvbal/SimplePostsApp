package com.ebalkaitis.simplepostsapp.posts.fragment

import android.os.Bundle
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerFragment
import javax.inject.Inject

class PostsFragment : BaseDaggerFragment(), PostsContract.View {
    @Inject
    lateinit var presenter: PostsContract.Presenter

    override fun getLayoutId() = R.layout.fragment_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.takeView(this)
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
