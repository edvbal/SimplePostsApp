package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsContract
import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsPresenter
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class PostsPresenterTest {
    private lateinit var presenter: PostsPresenter
    @Mock
    private lateinit var model: PostsContract.Model
    @Mock
    private lateinit var postsService: PostsService
    @Mock
    private lateinit var view: PostsContract.View

    private val testScheduler = TestScheduler()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PostsPresenter(model, testScheduler)
        presenter.takeView(view)
    }

    @Test
    fun onCreated_setsRecyclerView() {
        presenter.onCreated()

        verify(view).setRecyclerView()
    }

    @Test
    fun onCreated_whenPostsFetchSucceeds_populatesPosts() {
        val posts = listOf(Post(1, 1, "", ""))
        given(model.fetchPosts()).willReturn(Single.just(posts))

        presenter.onCreated()
        testScheduler.triggerActions()

        verify(view).populatePosts(posts)
    }

    @Test
    fun onCreated_whenPostsFetchFails_doesNotPopulatePosts() {
        given(model.fetchPosts()).willReturn(Single.error(Throwable()))

        presenter.onCreated()
        testScheduler.triggerActions()

        verify(view, never()).populatePosts(com.nhaarman.mockito_kotlin.any())
    }
}
