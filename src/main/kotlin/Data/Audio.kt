package ru.netology.Data

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val genreId: Int,
    val date: Int,
) : Attachment {

    override val type = "Audio"

    override fun toString(): String {
        return "($type: id= $id, ownerId= $ownerId, artist= $artist, title= $title, duration= $duration" +
                "url= $url, genreId= $genreId, date= $date)"
    }
}