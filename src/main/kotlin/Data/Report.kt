package ru.netology.Data

data class Report(
    val id: Int,
    val ownerId: Int,
    val commentId: Int,
    val reason: Int,
    val error: Int = 0
) {
}