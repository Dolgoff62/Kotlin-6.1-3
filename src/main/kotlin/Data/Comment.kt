package ru.netology.Data

data class Comment(
    val id: Int,
    val postId: Int,
    val date: Int,
    val text: String,
    val attachment: List<Attachment>,
) : Attachment {

    override val type = "Comment"

    override fun toString(): String {
        return "($type: id= $id, postId= $postId, date= $date, text= $text)"
    }
}