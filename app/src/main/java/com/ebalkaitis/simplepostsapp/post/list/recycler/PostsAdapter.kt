package com.ebalkaitis.simplepostsapp.post.list.recycler

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post

class PostsAdapter(private val factory: PostsViewHolderFactory) : RecyclerView.Adapter<PostsViewHolder>() {
    private val posts = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    fun setAll(posts: List<Post>) {
        this.posts.clear()
        this.posts.addAll(posts)
        notifyDataSetChanged()
    }
}
