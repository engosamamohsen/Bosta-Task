package app.bosta.task.presentation.gallery.image

import android.view.View
import androidx.databinding.ObservableField
import androidx.navigation.findNavController
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ZoomViewModel @Inject constructor(
) : BaseViewModel() {
  val photo = ObservableField(Photo())
  fun back(v: View){
    v.findNavController().popBackStack()
  }

  fun setData(photo: Photo) {
    this.photo.set(photo)
  }
}