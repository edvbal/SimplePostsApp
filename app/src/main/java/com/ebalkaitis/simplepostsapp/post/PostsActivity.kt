package com.ebalkaitis.simplepostsapp.post

import android.os.Bundle
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerActivity
import com.ebalkaitis.simplepostsapp.post.fragment.PostsFragment
import com.ebalkaitis.simplepostsapp.utils.extensions.replaceFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class PostsActivity : BaseDaggerActivity() {
    override fun getLayoutId() = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            replaceFragment(PostsFragment.newInstance(), R.id.fragmentContainer)
        }
    }
}
