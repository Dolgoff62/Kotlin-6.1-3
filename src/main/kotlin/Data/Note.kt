package ru.netology.Data

data class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int
) : Attachment {
    override val type = "Note"

    override fun toString(): String {
        return "($type: id= $id, ownerId= $ownerId, title= $title, text= $text, date= $date, comments= $comments)"
    }
}