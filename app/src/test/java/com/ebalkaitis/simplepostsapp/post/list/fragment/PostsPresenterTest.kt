package com.ebalkaitis.simplepostsapp.post.list.fragment

import com.ebalkaitis.simplepostsapp.post.list.mvp.PostsContract
import com.ebalkaitis.simplepostsapp.post.list.mvp.PostsPresenter
import com.ebalkaitis.simplepostsapp.utils.network.entities.Comment
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.entities.User
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
    private lateinit var view: PostsContract.View

    private val testScheduler = TestScheduler()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PostsPresenter(model, testScheduler)
        presenter.takeView(view)
    }

    @Test
    fun onCreated_afterDropView_doesNotInteractWithView() {
        given(model.fetchComments()).willReturn(Single.never())
        given(model.fetchUsers()).willReturn(Single.never())
        given(model.fetchPosts()).willReturn(Single.never())

        presenter.dropView()
        presenter.onCreated()

        verifyZeroInteractions(view)
    }

    @Test
    fun onCreated_whenPostsAndUsersAndCommentsFetchSucceedsAndViewWasDropped_doesNotPopulatePosts() {
        val posts = listOf(Post(1, 1, "", ""))
        given(model.fetchComments()).willReturn(Single.just(listOf(mock(Comment::class.java))))
        given(model.fetchUsers()).willReturn(Single.just(listOf(mock(User::class.java))))
        given(model.fetchPosts()).willReturn(Single.just(posts))

        presenter.onCreated()
        presenter.dropView()
        testScheduler.triggerActions()

        verify(view, never()).populatePosts(posts)
    }

    @Test
    fun onCreated_whenPostsFetchFails_doesNotPopulatePosts() {
        given(model.fetchComments()).willReturn(Single.just(listOf(mock(Comment::class.java))))
        given(model.fetchUsers()).willReturn(Single.just(listOf(mock(User::class.java))))
        given(model.fetchPosts()).willReturn(Single.error(Throwable()))

        presenter.onCreated()
        testScheduler.triggerActions()

        verify(view, never()).populatePosts(com.nhaarman.mockito_kotlin.any())
    }

    @Test
    fun onCreated_whenUsersFetchFails_doesNotPopulatePosts() {
        given(model.fetchComments()).willReturn(Single.just(listOf(mock(Comment::class.java))))
        given(model.fetchUsers()).willReturn(Single.error(Throwable()))

        presenter.onCreated()
        testScheduler.triggerActions()

        verify(view, never()).populatePosts(com.nhaarman.mockito_kotlin.any())
    }

    @Test
    fun onCreated_whenUsersAndCommentsFetchSucceeds_savesUsersAndFetchesPosts() {
        val users = listOf(mock(User::class.java))
        given(model.fetchComments()).willReturn(Single.just(listOf(mock(Comment::class.java))))
        given(model.fetchUsers()).willReturn(Single.just(users))

        presenter.onCreated()
        testScheduler.triggerActions()

        verify(model).saveUsers(users)
        verify(model).fetchPosts()
    }

    @Test
    fun onCreated_whenCommentsFetchFails_doesNotPopulatePosts() {
        given(model.fetchComments()).willReturn(Single.error(Throwable()))

        presenter.onCreated()
        testScheduler.triggerActions()

        verify(view, never()).populatePosts(com.nhaarman.mockito_kotlin.any())
    }

    @Test
    fun onCreated_whenCommentsAndUsersFetchSucceeds_savesCommentsAndFetchesUsers() {
        val comments = listOf(mock(Comment::class.java))
        given(model.fetchComments()).willReturn(Single.just(comments))

        presenter.onCreated()
        testScheduler.triggerActions()

        verify(model).saveComments(comments)
        verify(model).fetchUsers()
    }
}
