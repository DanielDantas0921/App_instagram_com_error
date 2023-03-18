package co.tiagoaguiar.course.instagram.post.presenter

import android.net.Uri
import co.tiagoaguiar.course.instagram.common.base.RequestCallback
import co.tiagoaguiar.course.instagram.common.model.UserAuth
import co.tiagoaguiar.course.instagram.post.Post
import co.tiagoaguiar.course.instagram.post.data.PostRepository
import co.tiagoaguiar.course.instagram.profile.Profile
import co.tiagoaguiar.course.instagram.profile.data.ProfileRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class PostPresenter(
  private var view: Post.View?,
  private val repository: PostRepository,
  private var uri: Uri? = null


) : Post.Presenter, CoroutineScope {
  private val job = Job()
  override  val coroutineContext: CoroutineContext = job + Dispatchers.IO
  override fun selectUri(uri: Uri) {
    this.uri = uri
  }

  override fun getSelectedUri(): Uri? {
    return uri
  }


  override fun fetchPictures() {
  view?.showProgress(true)
  launch {



   val pictures =  repository.fetchPictures()
    withContext(Dispatchers.Main){
      if (pictures.isEmpty()){
        view?.displayEmptyPictures()
      }else {
        view?.displayFullPictures(pictures)
      }
      view?.showProgress(false)
    }

  }

  }


  override fun onDestroy() {
    view = null
    job.cancel()
  }

}