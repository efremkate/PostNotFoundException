package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.netology.WallService.add
import ru.netology.WallService.update

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExistingTrue() {
        val post = Post(
            id = 2,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(2, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false,
            views = null,
            attachments = emptyArray(),
            replyPostId = 1,
            signerId = 1,
            reposts = null,
            replyOwnerId = 1,
            postponedId = 1,
            isFavorite = true,
            geo = null,
            donut = null,
            copyright = null,
            comments = emptyArray(),
            canPin = true,
            canDelete = true,
            canEdit = true,
            createdBy = 1
        )
        val test = WallService
        val id = test.add(post).id

        val updatedPost = Post(
            id = id,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "test content",
            friendsOnly = false,
            likes = Likes(2, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false,
            views = null,
            attachments = emptyArray(),
            replyPostId = 1,
            signerId = 1,
            reposts = null,
            replyOwnerId = 1,
            postponedId = 1,
            isFavorite = true,
            geo = null,
            donut = null,
            copyright = null,
            comments = emptyArray(),
            canPin = true,
            canDelete = true,
            canEdit = true,
            createdBy = 1
        )

        val excepted = true
        val result = update(updatedPost)
        assertEquals(excepted, result)
    }

    @Test
    fun updateExistingFalse() {
        val post = Post(
            id = 0,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(5, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false,
            views = null,
            attachments = emptyArray(),
            replyPostId = 1,
            signerId = 1,
            reposts = null,
            replyOwnerId = 1,
            postponedId = 1,
            isFavorite = true,
            geo = null,
            donut = null,
            copyright = null,
            comments = emptyArray(),
            canPin = true,
            canDelete = true,
            canEdit = true,
            createdBy = 1
        )

        val updatedPost = Post(
            id = 200,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(5, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false,
            views = null,
            attachments = emptyArray(),
            replyPostId = 1,
            signerId = 1,
            reposts = null,
            replyOwnerId = 1,
            postponedId = 1,
            isFavorite = true,
            geo = null,
            donut = null,
            copyright = null,
            comments = emptyArray(),
            canPin = true,
            canDelete = true,
            canEdit = true,
            createdBy = 1
        )
        val test = WallService
        test.add(post)
        val excepted = false
        val result = update(updatedPost)
        assertEquals(excepted, result)
    }

    @Test
    fun addPost() {
        val post = Post(
            id = 0,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(11, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false,
            views = null,
            attachments = emptyArray(),
            replyPostId = 1,
            signerId = 1,
            reposts = null,
            replyOwnerId = 1,
            postponedId = 1,
            isFavorite = true,
            geo = null,
            donut = null,
            copyright = null,
            comments = emptyArray(),
            canPin = true,
            canDelete = true,
            canEdit = true,
            createdBy = 1
        )

        val excepted = true
        val result = add(post).id != 0
        assertEquals(excepted, result)
    }

    @Test
    fun addComment() {
        val post = Post(
            id = 0,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(11, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false,
            views = null,
            attachments = emptyArray(),
            replyPostId = 1,
            signerId = 1,
            reposts = null,
            replyOwnerId = 1,
            postponedId = 1,
            isFavorite = true,
            geo = null,
            donut = null,
            copyright = null,
            comments = emptyArray(),
            canPin = true,
            canDelete = true,
            canEdit = true,
            createdBy = 1
        )

        val test = WallService
        test.add(post)

        val excepted = Comment(1, 1, 1, 1, 1, null)

        val result = test.createComment(postId = post.id,excepted)
        assertEquals(excepted, result)
    }


    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val post = Post(
            id = 0,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(11, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false,
            views = null,
            attachments = emptyArray(),
            replyPostId = 1,
            signerId = 1,
            reposts = null,
            replyOwnerId = 1,
            postponedId = 1,
            isFavorite = true,
            geo = null,
            donut = null,
            copyright = null,
            comments = emptyArray(),
            canPin = true,
            canDelete = true,
            canEdit = true,
            createdBy = 1
        )

        val test = WallService
        test.add(post)

        val excepted = Comment(1, 1, 1, 1, 1, null)

        val result = test.createComment(postId = 2,excepted)
    }
}


