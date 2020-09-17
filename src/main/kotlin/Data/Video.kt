package ru.netology.Data

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int,
    val views: Int,
) : Attachment {

    override val type = "Video"

    override fun toString(): String {
        return "($type: id= $id, ownerId= $ownerId, title= $title, description= $description, " +
                "duration= $duration, date= $date, views= $views)"
    }
}