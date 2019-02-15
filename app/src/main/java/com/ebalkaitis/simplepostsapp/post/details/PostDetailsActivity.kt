package com.ebalkaitis.simplepostsapp.post.details

import android.os.Bundle
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerActivity
import kotlinx.android.synthetic.main.layout_toolbar.*

class PostDetailsActivity : BaseDaggerActivity() {
    override fun getLayoutId() = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState == null) {
        }
    }
}
