package ru.netology

import org.junit.Assert.*
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
        val post = Post(id = 2,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(2, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false)
        val test = WallService
        val id = test.add(post).id

        val updatedPost = Post(id = id,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "test content",
            friendsOnly = false,
            likes = Likes(2, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false)

        val excepted = true
        val result = update(updatedPost)
        assertEquals(excepted, result)
    }

    @Test
    fun updateExistingFalse() {
        val post = Post(id = 0,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(5, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false)

        val updatedPost = Post(id = 200,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(5, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false)
        val test = WallService
        test.add(post)
        val excepted = false
        val result = update(updatedPost)
        assertEquals(excepted, result)
    }

    @Test
    fun addPost() {
        val post = Post(id = 0,
            ownerId = 21,
            fromId = 22,
            date = "01/10/15",
            text = "content",
            friendsOnly = false,
            likes = Likes(11, true, true, true),
            postType = "post",
            isPinned = false,
            markedAsAds = false)

        val excepted = true
        val result = add(post).id !=0
        assertEquals(excepted, result)
    }
}
