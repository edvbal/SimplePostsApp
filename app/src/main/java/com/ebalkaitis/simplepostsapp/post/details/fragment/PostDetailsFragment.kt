package com.ebalkaitis.simplepostsapp.post.details.fragment

import android.os.Bundle
import android.view.View
import com.ebalkaitis.simplepostsapp.R
import com.ebalkaitis.simplepostsapp.base.BaseDaggerFragment
import com.ebalkaitis.simplepostsapp.post.details.mvp.PostDetailsContract
import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails
import kotlinx.android.synthetic.main.fragment_post_details.*
import javax.inject.Inject

class PostDetailsFragment : BaseDaggerFragment(), PostDetailsContract.View {

    @Inject
    lateinit var presenter: PostDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.takeView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreated(arguments!!.getParcelable(POST_DETAILS_KEY)!!)
    }

    override fun populatePostDetails(postDetails: PostDetails) {
        titleTextView.text = postDetails.title
        bodyTextView.text = postDetails.body
        usernameTextView.text = getString(R.string.postDetailsUsernameLabel, postDetails.userName)
        commentsNumberTextView.text = getString(R.string.postDetailsNumberOfCommentsLabel, postDetails.numberOfComments)
    }

    override fun getLayoutId() = R.layout.fragment_post_details

    override fun onDestroyView() {
        presenter.dropView()
        super.onDestroyView()
    }

    companion object {
        private const val POST_DETAILS_KEY = "key.postDetails"

        fun newInstance(postDetails: PostDetails): PostDetailsFragment {
            val arguments = Bundle().apply { putParcelable(POST_DETAILS_KEY, postDetails) }
            return PostDetailsFragment().apply { this.arguments = arguments }
        }
    }
}
