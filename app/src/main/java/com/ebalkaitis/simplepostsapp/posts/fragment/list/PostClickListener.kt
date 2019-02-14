package com.ebalkaitis.simplepostsapp.posts.fragment.list

import com.ebalkaitis.simplepostsapp.utils.network.entities.Post

interface PostClickListener {
    fun onPostClicked(post: Post)
}
