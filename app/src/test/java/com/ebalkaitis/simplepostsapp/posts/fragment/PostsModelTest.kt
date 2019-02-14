package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsModel
import com.ebalkaitis.simplepostsapp.utils.network.entities.Comment
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.entities.User
import com.ebalkaitis.simplepostsapp.utils.network.services.CommentsService
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import com.ebalkaitis.simplepostsapp.utils.network.services.UsersService
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class PostsModelTest {
    private lateinit var model: PostsModel
    @Mock
    private lateinit var postsService: PostsService
    @Mock
    private lateinit var usersService: UsersService
    @Mock
    private lateinit var commentsService: CommentsService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        model = PostsModel(postsService, usersService, commentsService)
    }

    @Test
    fun fetchPosts_callsServiceToFetchPosts() {
        val posts = listOf(Post(1, 1, "", ""))
        given(postsService.getPosts()).willReturn(Single.just(posts))

        model.fetchPosts().test()
            .assertValue(posts)
    }

    @Test
    fun fetchUsers_callsServiceToFetchUsers() {
        val users = listOf(mock(User::class.java))
        given(usersService.getUsers()).willReturn(Single.just(users))

        model.fetchUsers().test()
            .assertValue(users)
    }

    @Test
    fun fetchComments_callsServiceToFetchComments() {
        val comments = listOf(mock(Comment::class.java))
        given(commentsService.getComments()).willReturn(Single.just(comments))

        model.fetchComments().test()
            .assertValue(comments)
    }

    @Test
    fun saveUsers_savesUsers() {
        val expectedUsers = listOf(mock(User::class.java))
        model.saveUsers(expectedUsers)

        val actualUsers = model.getUsers()

        assertEquals(expectedUsers, actualUsers)
    }

    @Test
    fun saveComments_savesComments() {
        val expectedComments = listOf(mock(Comment::class.java))
        model.saveComments(expectedComments)

        val actualComments = model.getComments()

        assertEquals(expectedComments, actualComments)
    }
}
