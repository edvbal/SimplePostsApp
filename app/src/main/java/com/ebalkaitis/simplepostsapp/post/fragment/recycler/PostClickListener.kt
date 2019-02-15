package com.ebalkaitis.simplepostsapp.post.fragment.recycler

import com.ebalkaitis.simplepostsapp.utils.network.entities.Post

interface PostClickListener {
    fun onPostClicked(post: Post)
}
