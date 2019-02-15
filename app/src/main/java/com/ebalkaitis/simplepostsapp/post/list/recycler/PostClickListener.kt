package com.ebalkaitis.simplepostsapp.post.list.recycler

import com.ebalkaitis.simplepostsapp.utils.network.entities.Post

interface PostClickListener {
    fun onPostClicked(post: Post)
}
