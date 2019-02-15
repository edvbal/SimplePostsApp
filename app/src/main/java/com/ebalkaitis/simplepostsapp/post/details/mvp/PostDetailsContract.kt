package com.ebalkaitis.simplepostsapp.post.details.mvp

import com.ebalkaitis.simplepostsapp.utils.mvp.BasePresenter

interface PostDetailsContract {
    interface View

    interface Presenter : BasePresenter<View>
}
