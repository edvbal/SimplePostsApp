package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsModel
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class PostsModelTest {
    private lateinit var model: PostsModel
    @Mock
    private lateinit var postsService: PostsService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        model = PostsModel(postsService)
    }

    @Test
    fun fetchPosts_callsServiceToFetchPosts() {
        val posts = listOf(Post(1, 1, "", ""))
        given(postsService.getPosts()).willReturn(Single.just(posts))

        model.fetchPosts().test()
            .assertValue(posts)
    }
}
