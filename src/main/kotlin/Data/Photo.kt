package ru.netology.Data

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
) : Attachment {

    override val type = "Photo"

    override fun toString(): String {
        return "($type: id= $id, albumId= $albumId, ownerId= $ownerId, userId= $userId, text= $text, date= $date)"
    }
}