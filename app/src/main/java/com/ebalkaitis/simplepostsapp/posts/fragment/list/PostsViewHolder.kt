package com.ebalkaitis.simplepostsapp.posts.fragment.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ebalkaitis.simplepostsapp.utils.network.responses.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostsViewHolder(view: View, private val listener: PostClickListener) : RecyclerView.ViewHolder(view) {

    fun bind(post: Post) {
        itemView.setOnClickListener { listener.onPostClicked(post) }
        itemView.titleTextView.text = post.title
    }
}
