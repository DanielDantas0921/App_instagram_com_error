package co.tiagoaguiar.course.instagram.common.model

import android.net.Uri
import java.io.File
import java.util.*

object Database {

    val usersAuth = hashSetOf<UserAuth>()
    val photos = hashSetOf<Photo>()
    val posts = hashMapOf<String, MutableSet<Post>>()
    val feeds = hashMapOf<String, MutableSet<Post>>()
    val followers = hashMapOf<String, Set<String>>()

    var sessionAuth: UserAuth? = null

    init {
        val userA =
            UserAuth(UUID.randomUUID().toString(), "UserA", "userA@gmail.com", "12345678")

        val userB =
            UserAuth(UUID.randomUUID().toString(), "UserB", "userB@gmail.com", "87654321")

        usersAuth.add(userA)
        usersAuth.add(userB)

        followers[userA.uuid] = hashSetOf()
        posts[userA.uuid] = hashSetOf()
        feeds[userA.uuid] = hashSetOf()


        followers[userB.uuid] = hashSetOf()
        posts[userB.uuid] = hashSetOf()
        feeds[userB.uuid] = hashSetOf()


        feeds[userA.uuid]?.addAll(

            arrayListOf(
                Post(UUID.randomUUID().toString(),
                    Uri.fromFile(File("/sdcard/Android/media/co.tiagoaguiar.course.instagram/Instagram/2023-03-10-15-25-30-775.jpg")), "desc" , System.currentTimeMillis() , userA)
            )
        )


        feeds[userA.uuid]?.addAll(

            arrayListOf(
                Post(UUID.randomUUID().toString(),
                    Uri.fromFile(File("asad")), "descriçao bla bal bla bla" , System.currentTimeMillis() , userA)
            )
        )

        feeds[userA.uuid]?.addAll(

            arrayListOf(
                Post(UUID.randomUUID().toString(),
                    Uri.fromFile(File("/sdcard/Android/media/co.tiagoaguiar.course.instagram/Instagram/2023-03-10-15-25-30-775.jpg")), "desc" , System.currentTimeMillis() , userA)
            )
        )

        feeds[userA.uuid]?.addAll(

            arrayListOf(
                Post(UUID.randomUUID().toString(),
                    Uri.fromFile(File("/sdcard/Android/media/co.tiagoaguiar.course.instagram/Instagram/2023-03-10-15-25-30-775.jpg")), "desc" , System.currentTimeMillis() , userA)
            )
        )

        feeds[userA.uuid]?.toList()?.let {
            feeds[userB.uuid]?.addAll(it)
        }


        sessionAuth = usersAuth.first()
    }

}