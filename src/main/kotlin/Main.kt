package ru.netology

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: String,
    val text: String,
    val friendsOnly: Boolean,
    var likes: Likes,
    val postType: String,
    val isPinned: Boolean,
    val markedAsAds: Boolean
)

object WallService {
    private var posts = emptyArray<Post>()
    private var ids = 1
    fun clear() {
        posts = emptyArray()
    }

    fun add(post: Post): Post {
        post.id = ids
        ids += 1
        posts += post
        return posts.last()
    }

    fun update(updatedPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == updatedPost.id) {
                val originalPost = posts[index]

                posts[index] = Post(
                    id = updatedPost.id,
                    ownerId = originalPost.ownerId,
                    fromId = updatedPost.fromId,
                    date = originalPost.date,
                    text = updatedPost.text,
                    friendsOnly = updatedPost.friendsOnly,
                    likes = updatedPost.likes,
                    postType = updatedPost.postType,
                    isPinned = updatedPost.isPinned,
                    markedAsAds = updatedPost.markedAsAds
                )

                return true
            }
        }

        return false
    }
}

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

fun main() {

}