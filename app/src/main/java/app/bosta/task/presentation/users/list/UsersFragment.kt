package app.bosta.task.presentation.users.list

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import app.bosta.task.domain.utils.Resource
import com.structure.base_mvvm.R
import app.bosta.task.presentation.base.BaseFragment
import app.bosta.task.presentation.base.extensions.handleApiError
import app.bosta.task.presentation.base.extensions.hideKeyboard
import app.bosta.task.presentation.users.list.viewModels.UsersViewModel
import com.structure.base_mvvm.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class UsersFragment : BaseFragment<FragmentUsersBinding>() {

  private val viewModel: UsersViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_users

  override
  fun setBindingVariables() {
    binding.viewModel = viewModel
  }
  override fun setupObservers() {
    super.setupObservers()
    lifecycleScope.launchWhenResumed {
      viewModel.usersResponse.collect {
        when (it) {
          Resource.Loading -> {
            hideKeyboard()
            showLoading()
          }
          is Resource.Success -> {
//            Log.d(TAG, "setupObservers: ${it.value.size}")
            hideLoading()
            viewModel.setData(it.value)
          }
          is Resource.Failure -> {
            hideLoading()
            handleApiError(it)
          }
        }
      }
    }

  }

}