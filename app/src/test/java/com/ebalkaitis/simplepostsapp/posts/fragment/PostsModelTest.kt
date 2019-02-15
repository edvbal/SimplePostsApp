package com.ebalkaitis.simplepostsapp.posts.fragment

import com.ebalkaitis.simplepostsapp.posts.fragment.mvp.PostsModel
import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails
import com.ebalkaitis.simplepostsapp.utils.network.entities.Comment
import com.ebalkaitis.simplepostsapp.utils.network.entities.Post
import com.ebalkaitis.simplepostsapp.utils.network.entities.User
import com.ebalkaitis.simplepostsapp.utils.network.services.CommentsService
import com.ebalkaitis.simplepostsapp.utils.network.services.PostsService
import com.ebalkaitis.simplepostsapp.utils.network.services.UsersService
import io.reactivex.Single
import org.junit.Assert.assertEquals
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
    fun getPostDetails_whenHasPost_returnsPostTitleAndBody() {
        val postToSearch = Post(USER_ID_ONE, POST_ID_ONE, TITLE, BODY)
        val differentPost = Post(USER_ID_ONE, POST_ID_TWO, TITLE, BODY)
        val expectedPostDetails = PostDetails(TITLE, BODY, "", 0)
        model.savePosts(listOf(postToSearch, differentPost))

        val actualPostDetails = model.getPostDetails(postToSearch)

        assertEquals(expectedPostDetails, actualPostDetails)
    }

    @Test
    fun getPostDetails_whenDoesNotHavePost_returnsEmptyTitleAndBody() {
        val postToSearch = Post(USER_ID_ONE, POST_ID_ONE, TITLE, BODY)
        val differentPost = Post(USER_ID_ONE, POST_ID_TWO, TITLE, BODY)
        val expectedPostDetails = PostDetails("", "", "", 0)
        model.savePosts(listOf(differentPost))

        val actualPostDetails = model.getPostDetails(postToSearch)

        assertEquals(expectedPostDetails, actualPostDetails)
    }

    @Test
    fun getPostDetails_whenHasUsername_returnsUsername() {
        val postToSearch = Post(USER_ID_ONE, POST_ID_ONE, "", "")
        val user = mockUser(USER_ID_ONE, USERNAME)
        val expectedPostDetails = PostDetails("", "", USERNAME, 0)
        model.saveUsers(listOf(user))

        val actualPostDetails = model.getPostDetails(postToSearch)

        assertEquals(expectedPostDetails, actualPostDetails)
    }

    @Test
    fun getPostDetails_whenDoesNotHaveUsername_returnsEmptyUsername() {
        val postToSearch = Post(USER_ID_ONE, POST_ID_ONE, "", "")
        val user = mockUser(USER_ID_TWO, USERNAME)
        val expectedPostDetails = PostDetails("", "", "", 0)
        model.saveUsers(listOf(user))

        val actualPostDetails = model.getPostDetails(postToSearch)

        assertEquals(expectedPostDetails, actualPostDetails)
    }

    @Test
    fun getPostDetails_whenHasComments_returnsNumberOfComments() {
        val postToSearch = Post(USER_ID_ONE, POST_ID_ONE, "", "")
        val commentOne = mockComment(POST_ID_ONE)
        val commentTwo = mockComment(POST_ID_ONE)
        val comments = listOf(commentOne, commentTwo)
        val expectedPostDetails = PostDetails("", "", "", comments.size)
        model.saveComments(comments)

        val actualPostDetails = model.getPostDetails(postToSearch)

        assertEquals(expectedPostDetails, actualPostDetails)
    }

    private fun mockUser(id: Int, username: String): User {
        val user = mock(User::class.java)
        given(user.id).willReturn(id)
        given(user.username).willReturn(username)
        return user
    }

    private fun mockComment(postId: Int): Comment {
        val comment = mock(Comment::class.java)
        given(comment.postId).willReturn(postId)
        return comment
    }

    companion object {
        private const val TITLE = "TITLE"
        private const val BODY = "BODY"
        private const val USERNAME = "USERNAME"
        private const val NUMBER_OF_COMMENTS = 0
        private const val USER_ID_ONE = 1
        private const val USER_ID_TWO = 2
        private const val POST_ID_ONE = 1
        private const val POST_ID_TWO = 2
    }
}
