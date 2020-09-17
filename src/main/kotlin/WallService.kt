package ru.netology

import ru.netology.Data.*
import ru.netology.Exceptions.*


object WallService {
    private var posts = mutableListOf<Post>()
    private var comments = mutableListOf<Comment>()
    private var reports = mutableListOf<Report>()
    private var lastId = 1

    fun add(post: Post): Post {
        posts.plusAssign(post.copy(id = lastId++))
        return posts.last()
    }

    fun update(post: Post): Boolean {

        try {
            for (i: Int in 0..posts.size) {
                val searchPost = posts[i]
                if (post.id == searchPost.id) {
                    val updatedPost = post.copy(
                        id = searchPost.id,
                        ownerId = searchPost.ownerId,
                        date = searchPost.date
                    )

                    posts[i] = updatedPost

                    return true
                }
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Поста с Id = ${post.id} не существует!")
            return false
        }
        return false
    }

    fun createComment(comment: Comment): Boolean {

        for (post: Post in posts) {
            if (post.id == comment.postId) {
                comments.add(comment)

                return true
            }
        }
        return false
    }

    fun checkingCommentCreation(comment: Comment): Boolean {
        if (!createComment(comment)) {
            throw PostNotFoundException("Поста с таким Id не существует!")
        }
        return true
    }

    fun reportCommentError(report: Report): Boolean {

         when(report.error){
                1 -> throw IdError("Неверный ID")
                2 -> throw InternalServerError("Произошла внутренняя ошибка сервера")
                3 -> throw AccessIsDeniedError("Доступ запрещен!")
                4 -> throw UserAuthorizationFailed("Авторизация пользователя не удалась")
                5 -> throw BadRequest("Неверный запрос")
        }
        return true
    }

    fun reportCommentReason(report: Report): Report{

        when(report.reason){
            1 -> println("Коммент отмечен как Спам")
            2 -> println("Коммент отмечен как детская порнография")
            3 -> println("Коммент отмечен как экстремистский")
            4 -> println("Коммент отмечен как насилие")
            5 -> println("Коммент отмечен как пропаганда наркотиков")
            6 -> println("Коммент отмечен как материал для взрослых")
            7 -> println("Коммент отмечен как оскорбление")
            8 -> println("Коммент отмечен как призыв к суициду")
        }
        reports.plusAssign(report)
        return reports.last()
    }

    fun printPosts() {
        for ((index, value) in posts.withIndex()) {
            println("Значение индекса $index содержимое $value")
            println("\tвложения:")
            for (att: Attachment in value.attachments) {
                when (att.type) {
                    "Note" -> println("\t\tNote")
                    "Photo" -> println("\t\tPhoto")
                    "Document" -> println("\t\tDocument")
                    "Audio" -> println("\t\tAudio")
                    "Video" -> println("\t\tVideo")
                    else -> println("\t\tunknown")
                }
            }
            println("\n\tкомментарии:")
            for (comm: Comment in value.comments) {
                println("$comm")
            }
        }
    }


    fun printComments() {
        for ((index, value) in comments.withIndex()) {
            println("Значение индекса $index содержимое $value")
        }
    }

    fun printReports() {
        for ((index, value) in reports.withIndex()) {
            println("Значение индекса $index содержимое $value")
        }
    }
}
