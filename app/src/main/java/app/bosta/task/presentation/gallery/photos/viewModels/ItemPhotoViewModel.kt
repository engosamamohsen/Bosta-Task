package app.bosta.task.presentation.gallery.photos.viewModels

import android.view.View
import androidx.databinding.ObservableInt
import androidx.fragment.app.findFragment
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.domain.user.models.User
import app.bosta.task.presentation.base.BaseViewModel
import app.bosta.task.presentation.base.extensions.navigateSafe
import app.bosta.task.presentation.gallery.photos.views.PhotosFragment
import app.bosta.task.presentation.gallery.photos.views.PhotosFragmentDirections

class ItemPhotoViewModel constructor(val photo: Photo) : BaseViewModel() {
  fun submit(v: View){
    v.findFragment<PhotosFragment>().navigateSafe(PhotosFragmentDirections.actionPhotosFragmentToZoomFragment(photo))
  }
}