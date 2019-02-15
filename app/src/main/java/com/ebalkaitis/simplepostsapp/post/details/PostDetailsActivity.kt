package com.ebalkaitis.simplepostsapp.post.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerActivity
import com.ebalkaitis.simplepostsapp.post.details.fragment.PostDetailsFragment
import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails
import com.ebalkaitis.simplepostsapp.utils.extensions.replaceFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class PostDetailsActivity : BaseDaggerActivity() {
    override fun getLayoutId() = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState == null) {
            replaceFragment(PostDetailsFragment.newInstance(getPostDetails()))
        }
    }

    private fun getPostDetails(): PostDetails {
        return intent.extras!!.getParcelable(POST_DETAILS_KEY)!!
    }

    companion object {
        private const val POST_DETAILS_KEY = "key.postDetails"

        fun start(context: Context?, postDetails: PostDetails) {
            context?.let { context.startActivity(createIntent(context, postDetails)) }
        }

        private fun createIntent(context: Context?, postDetails: PostDetails): Intent {
            val intent = Intent(context, PostDetailsActivity::class.java).apply { }
            intent.putExtra(POST_DETAILS_KEY, postDetails)
            return intent
        }
    }
}
