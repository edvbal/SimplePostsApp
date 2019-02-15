package com.ebalkaitis.simplepostsapp.post.details.mvp

import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails
import com.ebalkaitis.simplepostsapp.utils.mvp.BasePresenter

interface PostDetailsContract {
    interface View {
        fun populatePostDetails(postDetails: PostDetails)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated(postDetails: PostDetails)
    }
}
