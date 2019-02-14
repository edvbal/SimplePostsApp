package com.ebalkaitis.simplepostsapp.posts.fragment

import android.os.Bundle
import android.view.View
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerFragment
import com.ebalkaitis.simplepostsapp.posts.fragment.list.PostClickListener
import com.ebalkaitis.simplepostsapp.posts.fragment.list.PostsAdapter
import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsContract
import com.ebalkaitis.simplepostsapp.utils.network.responses.Post
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

class PostsFragment : BaseDaggerFragment(), PostsContract.View, PostClickListener {
    @Inject
    lateinit var presenter: PostsContract.Presenter

    @Inject
    lateinit var adapter: PostsAdapter

    override fun getLayoutId() = R.layout.fragment_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.takeView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreated()
    }

    override fun onPostClicked(post: Post) {
    }

    override fun setRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }


    override fun populatePosts(posts: List<Post>) {
        adapter.setAll(posts)
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
