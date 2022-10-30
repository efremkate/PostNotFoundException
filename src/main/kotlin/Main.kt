package ru.netology

import java.util.*

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: String,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    var comments: Array<Comment> = emptyArray(),
    val copyright: Copyrights?,
    var likes: Likes?,
    val reposts: Reposts?,
    val views: Views?,
    val postType: String,
    var attachments: Array<Attachment> = emptyArray(),
    val geo: Geo?,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donuts?,
    val postponedId: Int,
)

object WallService {
    private var posts = emptyArray<Post>()

    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, post) in posts.withIndex()) {
            if (post.id == postId) {

                posts[index].comments += comment

                return comment
            }
        }

        return throw PostNotFoundException("no post with id $postId")
    }

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
                    markedAsAds = updatedPost.markedAsAds,
                    canEdit = updatedPost.canEdit,
                    canDelete = updatedPost.canDelete,
                    canPin = updatedPost.canPin,
                    comments = updatedPost.comments,
                    copyright = updatedPost.copyright,
                    createdBy = updatedPost.createdBy,
                    donut = updatedPost.donut,
                    geo = updatedPost.geo,
                    isFavorite = updatedPost.isFavorite,
                    postponedId = updatedPost.postponedId,
                    replyOwnerId = updatedPost.replyOwnerId,
                    replyPostId = updatedPost.replyPostId,
                    reposts = updatedPost.reposts,
                    signerId = updatedPost.signerId,
                    views = updatedPost.views,
                    attachments = updatedPost.attachments
                )

                return true
            }
        }

        return false
    }
}

class PostNotFoundException(message: String) : RuntimeException(message)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int
)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
)

data class Graffiti(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
)

abstract class Attachment(
    val type: String
)

class PhotoAttachment(val photo: Photo) : Attachment(type = "photo")
class VideoAttachment(val video: Video) : Attachment(type = "video")
class AudioAttachment(val audio: Audio) : Attachment(type = "audio")
class DocAttachment(val doc: Doc) : Attachment(type = "doc")
class GraffitiAttachment(val graffiti: Graffiti) : Attachment(type = "graffiti")

data class Donuts(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: Objects,
    val canPublishFreeCopy: Boolean,
    val editMode: String
)

data class Copyrights(
    val id: Int,
    val link: String,
    val name: String,
    val type: String,
)

data class Geo(
    val type: String,
    val coordinates: String,
    val place: Place,
)

data class Place(
    val id: Int,
    val title: String,
    val latitude: Int,
    val longitude: Int,
    val created: Int,
    val icon: String,
    val checkins: Int,
    val updated: Int,
    val type: Int,
    val country: Int,
    val city: Int,
    val address: String,
)

data class Views(
    val count: Int
)


data class Reposts(
    val count: Int,
    val userReposted: Boolean,
)

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Attachment?
)

fun main() {
    val post = Post(
        1,
        1,
        1,
        1,
        "1",
        "1",
        1,
        1,
        true,
        arrayOf(),
        null,
        null,
        null,
        null,
        "1",
        arrayOf(PhotoAttachment(Photo(1, 1, 1, 1, "asd", 2))),
        null,
        1,
        true,
        true,
        true,
        true,
        true,
        true,
        null,
        1
    )
    println(post)

    WallService.add(post)
    val a = WallService.createComment(1, comment = Comment(1, 1, 1, 1, 1, null))
    println(a)

    val b = WallService.createComment(2, comment = Comment(1, 1, 1, 1, 1, null))
}