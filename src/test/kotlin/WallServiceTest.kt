import org.junit.Test
import ru.netology.WallService
import ru.netology.Data.*
import org.junit.Assert.*
import ru.netology.Exceptions.*


class WallServiceTest {

    @Test
    fun add() {

        // act
        val result = WallService.add(
            Post(
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
        )

        // assert
        assertTrue(result.id != 0)
    }

    @Test
    fun update_True() {

        // arrange
        WallService.add(
            Post(
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
        )
        val update = Post(
            id = 1,
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
            attachments = listOf(Photo(123, 321, 999, 12, "Collage", 2020_05_12)),
            signerId = 0,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = true,
            postponedId = 0
        )

        // act
        val result = WallService.update(update)

        // assert
        assertTrue(result)

    }

    @Test
    fun update_False() {

        // arrange
        WallService.add(
            Post(
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
        )
        val update = Post(
            id = 5,
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
            postponedId = 0
        )

        //act
        val result = WallService.update(update)

        // assert
        assertFalse(result)
    }

    @Test
    fun createComment_True() {

        // arrange
        val post = WallService.add(
            Post(
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
        )
        val comment = Comment(111, 1, 2020_09_12, "Че кого?", emptyList())

        // act
        WallService.createComment(comment)

        // assert
        assert(post.id == comment.postId)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {

        // arrange
        WallService.add(
            Post(
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
        )
        val comment = Comment(111, 6, 2020_09_12, "Че кого?", emptyList())

        // act
        WallService.checkingCommentCreation(comment)

        // assert
        shouldThrow()
    }

    @Test
    fun checkingCommentCreation_True() {

        // arrange
        WallService.add(
            Post(
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
        )
        val comment = Comment(111, 1, 2020_09_12, "Че кого?", emptyList())

        // act
        val result = WallService.checkingCommentCreation(comment)

        // assert
        assertTrue(result)
    }

    @Test(expected = IdError::class)
    fun reportCommentError_IdError() {

        // arrange
        val report = Report(1, 222, 111, 0, 1)

        // act
        WallService.reportCommentError(report)

        // assert
        reportCommentError_IdError()
    }

    @Test(expected = InternalServerError::class)
    fun reportCommentError_InternalServerError() {

        // arrange
        val report = Report(1, 222, 111, 0, 2)

        // act
        WallService.reportCommentError(report)

        // assert
        reportCommentError_InternalServerError()
    }

    @Test(expected = AccessIsDeniedError::class)
    fun reportCommentError_AccessIsDeniedError() {

        // arrange
        val report = Report(1, 222, 111, 0, 3)

        // act
        WallService.reportCommentError(report)

        // assert
        reportCommentError_AccessIsDeniedError()
    }

    @Test(expected = UserAuthorizationFailed::class)
    fun reportCommentError_UserAuthorizationFailed() {

        // arrange
        val report = Report(1, 222, 111, 0, 4)

        // act
        WallService.reportCommentError(report)

        // assert
        reportCommentError_UserAuthorizationFailed()
    }

    @Test(expected = BadRequest::class)
    fun reportCommentError_BadRequest() {

        // arrange
        val report = Report(1, 222, 111, 0, 5)

        // act
        WallService.reportCommentError(report)

        // assert
        reportCommentError_BadRequest()
    }

    @Test
    fun reportCommentError_WithoutError() {

        // arrange
        val report = Report(1, 222, 111, 0, 0)

        // act
        val result = WallService.reportCommentError(report)

        // assert
        assert(result)
    }

    @Test
    fun reportCommentReason_Spam() {

        // arrange
        val report = Report(1, 222, 111, 1, 0)

        // act
        val result = WallService.reportCommentReason(report)

        // assert
        assertEquals(result, report)
    }
}
