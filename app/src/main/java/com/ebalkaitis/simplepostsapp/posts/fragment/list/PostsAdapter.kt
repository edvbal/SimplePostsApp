package com.ebalkaitis.simplepostsapp.posts.fragment.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ebalkaitis.simplepostsapp.utils.network.responses.Post
import javax.inject.Inject

class PostsAdapter(private val factory: PostsViewHolderFactory) : RecyclerView.Adapter<PostsViewHolder>() {
    private val articles = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    fun setAll(articles: List<Post>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }
}
