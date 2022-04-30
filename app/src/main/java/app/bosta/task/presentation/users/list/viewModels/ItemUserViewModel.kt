package app.bosta.task.presentation.users.list.viewModels

import android.view.View
import androidx.databinding.ObservableInt
import androidx.fragment.app.findFragment
import app.bosta.task.domain.user.models.User
import app.bosta.task.presentation.base.BaseViewModel
import app.bosta.task.presentation.base.extensions.navigateSafe
import app.bosta.task.presentation.users.list.UsersFragment
import app.bosta.task.presentation.users.list.UsersFragmentDirections

class ItemUserViewModel constructor(val user: User) : BaseViewModel() {

  fun submit(v: View){
    v.findFragment<UsersFragment>().navigateSafe(UsersFragmentDirections.actionUsersFragmentToAlbumsFragment(user.username,user.id))
  }
}