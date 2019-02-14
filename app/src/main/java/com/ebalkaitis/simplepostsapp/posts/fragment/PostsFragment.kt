package com.ebalkaitis.simplepostsapp.posts.fragment

import android.os.Bundle
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerFragment
import javax.inject.Inject

class PostsFragment : BaseDaggerFragment(), PostsContract.View {
    override fun getLayoutId() = R.layout.fragment_posts

    companion object {
        fun newInstance(): PostsFragment {
            return PostsFragment()
        }
    }
}
