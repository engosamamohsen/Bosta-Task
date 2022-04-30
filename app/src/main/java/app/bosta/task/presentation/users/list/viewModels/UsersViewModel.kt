package app.bosta.task.presentation.users.list.viewModels

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import app.bosta.task.domain.user.models.User
import app.bosta.task.domain.user.use_case.UsersUseCase
import app.bosta.task.domain.utils.Resource
import com.structure.base_mvvm.BR
import app.bosta.task.presentation.base.BaseViewModel
import app.bosta.task.presentation.users.list.adapters.UsersAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
  private val useCase: UsersUseCase
) : BaseViewModel() {

  @Bindable
  val adapter: UsersAdapter = UsersAdapter()
  val usersResponse =
    MutableStateFlow<Resource<List<User>>>(Resource.Default)

  init {
    callService()
  }

  private fun callService() {
    useCase()
      .onEach { result ->
        usersResponse.value = result
      }
      .launchIn(viewModelScope)
  }

  fun setData(users: List<User>) {
    adapter.differ.submitList(users)
    notifyPropertyChanged(BR.adapter)
  }

}