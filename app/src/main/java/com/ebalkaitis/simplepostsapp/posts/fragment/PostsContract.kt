package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.utils.mvp.BasePresenter

interface PostsContract {
    interface Model

    interface View

    interface Presenter : BasePresenter<View>
}
