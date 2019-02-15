package com.ebalkaitis.simplepostsapp.post.details.fragment

import android.os.Bundle
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerFragment
import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails

class PostDetailsFragment : BaseDaggerFragment() {

    override fun getLayoutId() = R.layout.fragment_post_details

    companion object {
        private const val POST_DETAILS_KEY = "key.postDetails"

        fun newInstance(postDetails: PostDetails): PostDetailsFragment {
            val arguments = Bundle().apply { putParcelable(POST_DETAILS_KEY, postDetails) }
            return PostDetailsFragment().apply { this.arguments = arguments }
        }
    }
}
