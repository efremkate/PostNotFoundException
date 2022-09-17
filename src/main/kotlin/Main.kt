package ru.netology

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean,
    var likes: Likes,
    val postType: String,
    val isPinned: Boolean,
    val markedAsAds: Boolean
)

object WallService {
    private var posts = emptyArray<Post>()
    }

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

fun main() {

}