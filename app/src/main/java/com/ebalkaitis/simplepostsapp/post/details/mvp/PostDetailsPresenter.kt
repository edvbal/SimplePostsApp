package com.ebalkaitis.simplepostsapp.post.details.mvp

import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails
import com.ebalkaitis.simplepostsapp.utils.mvp.ViewPresenter

class PostDetailsPresenter : PostDetailsContract.Presenter, ViewPresenter<PostDetailsContract.View>() {

    override fun onCreated(postDetails: PostDetails) {
        onView { populatePostDetails(postDetails) }
    }
}
