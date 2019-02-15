package com.ebalkaitis.simplepostsapp.post.list.fragment

import android.os.Bundle
import android.view.View
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerFragment
import com.ebalkaitis.simplepostsapp.post.list.mvp.PostsContract
import com.ebalkaitis.simplepostsapp.post.list.recycler.PostClickListener
import com.ebalkaitis.simplepostsapp.post.list.recycler.PostsAdapter
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

class PostsFragment : BaseDaggerFragment(), PostsContract.View,
    PostClickListener {
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
        presenter.onPostClicked(post)
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
