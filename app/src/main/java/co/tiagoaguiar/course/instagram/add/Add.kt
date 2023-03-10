package co.tiagoaguiar.course.instagram.add

import android.net.Uri
import co.tiagoaguiar.course.instagram.common.base.BasePresenter
import co.tiagoaguiar.course.instagram.common.base.BaseView

interface Add {

  interface Presenter : BasePresenter {

    fun create(uri: Uri, caption: String)
  }

  interface View : BaseView<Presenter> {
    fun showProgress(enabled: Boolean)
    fun displayRequestSucess()
    fun displayRequestFailure(message:String)
  }

}