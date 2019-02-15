package com.ebalkaitis.simplepostsapp.post.details.mvp

import com.ebalkaitis.simplepostsapp.utils.entities.PostDetails
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class PostDetailsPresenterTest {
    private lateinit var presenter: PostDetailsPresenter
    @Mock
    private lateinit var view: PostDetailsContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PostDetailsPresenter()
        presenter.takeView(view)
    }

    @Test
    fun onCreated_hasView_populatesPostDetails() {
        val postDetails = mock(PostDetails::class.java)

        presenter.onCreated(postDetails)

        verify(view).populatePostDetails(postDetails)
    }

    @Test
    fun onCreated_hasNoView_doesNotInteractWithView() {
        val postDetails = mock(PostDetails::class.java)

        presenter.dropView()
        presenter.onCreated(postDetails)

        verifyZeroInteractions(view)
    }
}
