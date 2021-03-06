package com.ebalkaitis.simplepostsapp.post.list.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ebalkaitis.simplepostsapp.R

class PostsViewHolderFactory(private val listener: PostClickListener) {

    fun create(parent: ViewGroup): PostsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_post, parent, false)
        return PostsViewHolder(view, listener)
    }
}
