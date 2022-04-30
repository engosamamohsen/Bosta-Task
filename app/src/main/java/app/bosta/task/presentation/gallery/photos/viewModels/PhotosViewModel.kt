package app.bosta.task.presentation.gallery.photos.viewModels

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.viewModelScope
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.domain.user.models.User
import app.bosta.task.domain.user.use_case.UsersUseCase
import app.bosta.task.domain.utils.Resource
import com.structure.base_mvvm.BR
import app.bosta.task.presentation.base.BaseViewModel
import app.bosta.task.presentation.gallery.photos.adapters.PhotosAdapter
import app.bosta.task.presentation.users.list.adapters.UsersAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
  private val useCase: UsersUseCase
) : BaseViewModel() {

  @Bindable
  val adapter: PhotosAdapter = PhotosAdapter()


  val response =
    MutableStateFlow<Resource<List<Photo>>>(Resource.Default)

  fun search(): PhotosAdapter{
    return adapter
  }

companion object {
  @JvmStatic
  @BindingAdapter(
    value = ["app:search"],
    requireAll = false
  )
  fun search(view: AppCompatEditText?, adapter: PhotosAdapter?) {
    view?.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }
      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }
      override fun afterTextChanged(text: Editable?) {
        text?.toString()?.trim()?.let {
          adapter?.search(it)
        }
      }
    })
  }
}

  fun callService(albumId: Int) {
    useCase.photos(albumId)
      .onEach { result ->
        response.value = result
      }
      .launchIn(viewModelScope)
  }

  fun setData(list: List<Photo>) {
    adapter.originalList.addAll(list)
    adapter.differ.submitList(list)
    notifyPropertyChanged(BR.adapter)
  }

}