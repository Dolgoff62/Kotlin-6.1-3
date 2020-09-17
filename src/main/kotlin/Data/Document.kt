package ru.netology.Data

data class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val url: String,
    val date: Int
) : Attachment {

    override val type = "Document"

    override fun toString(): String {
        return "($type: id= $id, ownerId= $ownerId, title= $title, size= $size, url= $url, date= $date)"
    }
}