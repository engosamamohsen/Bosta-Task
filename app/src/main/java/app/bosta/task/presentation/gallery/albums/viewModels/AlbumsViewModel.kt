package app.bosta.task.presentation.gallery.albums.viewModels

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import app.bosta.task.domain.gallery.album.Album
import app.bosta.task.domain.user.models.User
import app.bosta.task.domain.user.use_case.UsersUseCase
import app.bosta.task.domain.utils.Resource
import com.structure.base_mvvm.BR
import app.bosta.task.presentation.base.BaseViewModel
import app.bosta.task.presentation.gallery.albums.adapters.AlbumsAdapter
import app.bosta.task.presentation.users.list.adapters.UsersAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
  private val useCase: UsersUseCase
) : BaseViewModel() {

  @Bindable
  val adapter: AlbumsAdapter = AlbumsAdapter()

  val response =
    MutableStateFlow<Resource<List<Album>>>(Resource.Default)

  fun callService(userId: Int) {
    useCase.albums(userId)
      .onEach { result ->
        response.value = result
      }
      .launchIn(viewModelScope)
  }

  fun setData(albums: List<Album>) {
    adapter.differ.submitList(albums)
    notifyPropertyChanged(BR.adapter)
  }

}