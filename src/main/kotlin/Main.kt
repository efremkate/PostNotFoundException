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
    private var ids=1

    fun add(post: Post): Post {
        post.id=ids
        ids += 1
        posts += post
        return posts.last() //ЗАДАЧА - ДОБАВИТЬ ЗАПИСЬ В МАССИВ, НО НАЗНАЧИТЬ УНИКАЛЬНЫЙ ИДЕНТИФИКАТОР,
    // Т.Е. НУЖНА ПЕРЕМЕННАЯ ДЛЯ ХРАНЕНИЯ
    }

    fun update(post: Post): Boolean {
        val originalPost= posts[post.id]

        return if (originalPost != null) {
            posts[post.id]= Post(id =  post.id, ownerId = originalPost.ownerId, fromId = post.fromId, date = originalPost.date, text = post.text, friendsOnly = post.friendsOnly,
                likes = post.likes, postType = post.postType, isPinned = post.isPinned, markedAsAds = post.markedAsAds)
            true
        } else {
            false
        }

//
//        for((index, posted) in posts.withIndex()) {
//            if (posted.id == post.id) {
//                posts[index] = post
//            //post.copy(post = original.ownerId + original.fromId + original.date + update)//Он должен находить среди всех постов запись с тем же id,
//                // что и у post и обновлять все свойства, кроме id владельца и даты создания.
//                //Если пост с таким id не найден, то ничего не происходит и возвращается false, в противном случае - возвращается true.
//            }
//            else false
//        }
    }
}

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

fun main() {
    val like = Likes(1, userLikes = true, canLike = true, canPublish = true)
    val like2 = Likes(100, userLikes = true, canLike = true, canPublish = true)

    var x = 1
    val test =WallService
    while (x !=11) {
        val post = Post (0, x, x, "${x}/10/22", "content", false, like, "post", isPinned = false, markedAsAds = false)
        test.add(post)
        x++
    }
    val post = Post (5, 100, 9990, "1/10/24", "test content", true, like2, "post", isPinned = true, markedAsAds = true)
    test.update(post)
//    test.add(post)
//    test.add(post)
//    test.add(post)
    println(post)
}