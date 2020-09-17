package ru.netology

import ru.netology.Data.*

fun main() {

    val firstPost = Post(
        ownerId = 555,
        fromId = 12,
        createdBy = 567,
        date = 2020_09_01,
        text = "Hello, its my first post.",
        replyOwnerId = 0,
        replyPostId = 0,
        friendsOnly = false,
        comments = emptyList(),
        copyright = "",
        likes = 10,
        repost = null,
        views = 15,
        postType = "",
        attachments = emptyList(),
        signerId = 0,
        canPin = false,
        canDelete = false,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 0
    )

    val secondPost = Post(
        ownerId = 123,
        fromId = 0,
        createdBy = 500,
        date = 2020_09_02,
        text = "Hello, its my second post.",
        replyOwnerId = 0,
        replyPostId = 0,
        friendsOnly = false,
        comments = emptyList(),
        copyright = "",
        likes = 0,
        repost = null,
        views = 0,
        postType = "",
        attachments = listOf(
            Note(
                1,
                123,
                "Note-1",
                "Its my first note",
                2020_01_12,
                1
            ),
            Document(
                23,
                123,
                "Instruction",
                12,
                "www.wikipedia.com",
                2020_03_05
            )),
        signerId = 0,
        canPin = false,
        canDelete = false,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        postponedId = 0
    )

    val thirdPost = Post(
        ownerId = 321,
        fromId = 98,
        createdBy = 987,
        date = 2020_07_15,
        text = "Hello, its my third post.",
        replyOwnerId = 0,
        replyPostId = 0,
        friendsOnly = false,
        comments = emptyList(),
        copyright = "",
        likes = 100,
        repost = null,
        views = 15,
        postType = "",
        attachments = listOf(Photo(123, 321, 999, 12, "Collage", 2020_05_12),
            Video(21, 333, "Monkey Island", "Funny movie", 312, 2020_01_01, 100),
            Note(999, 123, "Some Note", "my first note", 2020_03_01, 0)
        ),
        signerId = 0,
        canPin = false,
        canDelete = false,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 0
    )

    val updatedPost = Post(
        id = 3,
        ownerId = 555,
        fromId = 12,
        createdBy = 567,
        date = 2020_09_01,
        text = "This is a Edited Post",
        replyOwnerId = 0,
        replyPostId = 0,
        friendsOnly = false,
        comments = emptyList(),
        copyright = "",
        likes = 55,
        repost = null,
        views = 154,
        postType = "",
        attachments = emptyList(),
        signerId = 0,
        canPin = false,
        canDelete = false,
        canEdit = false,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        postponedId = 0)

    val firstComment = Comment(111, 1, 2020_09_12, "Че кого?", emptyList())
    val secondComment = Comment(222, 2, 2020_09_13, "Второй коммент", emptyList())
    val thirdComment = Comment(333, 3, 2020_09_14, "третий коммент", emptyList())
    val fourthComment = Comment(444, 2, 2020_09_15, "четвертый коммент", emptyList())

    val firstReport = Report(1, 222, 111, 1, 0)


    WallService.add(firstPost)
    WallService.add(secondPost)
    WallService.add(thirdPost)

    WallService.update(updatedPost)

    WallService.checkingCommentCreation(firstComment)
    WallService.checkingCommentCreation(secondComment)
    WallService.checkingCommentCreation(thirdComment)
    WallService.checkingCommentCreation(fourthComment)

    WallService.reportCommentError(firstReport)
    WallService.reportCommentReason(firstReport)

    WallService.printPosts()
    WallService.printComments()

    WallService.printReports()
}