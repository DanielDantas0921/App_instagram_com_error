package co.tiagoaguiar.course.instagram.add.data

import android.app.DownloadManager.Request
import android.net.Uri
import co.tiagoaguiar.course.instagram.common.base.RequestCallback
import kotlinx.coroutines.channels.consumesAll

class AddRepository(private val remoteDataSource: AddFakeDataSource,
                    private val localDataSource: AddLocalDataSource) {

    fun createPost(uri: Uri, caption: String, callback: RequestCallback<Boolean>){
            val userAuth = localDataSource.fetchSession()

        remoteDataSource.createPost(userAuth.uuid, uri, caption, object: RequestCallback<Boolean>{
            override fun onSuccess(data: Boolean) {
                callback.onSuccess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }

            override fun onComplete() {
                callback.onComplete()
            }

        })
    }

}