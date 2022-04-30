package app.bosta.task.presentation.gallery.albums

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import app.bosta.task.domain.utils.Resource
import com.structure.base_mvvm.R
import app.bosta.task.presentation.base.BaseFragment
import app.bosta.task.presentation.base.extensions.handleApiError
import app.bosta.task.presentation.base.extensions.hideKeyboard
import app.bosta.task.presentation.gallery.albums.viewModels.AlbumsViewModel
import app.bosta.task.presentation.users.list.viewModels.UsersViewModel
import com.structure.base_mvvm.databinding.FragmentAlbumsBinding
import com.structure.base_mvvm.databinding.FragmentUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class AlbumsFragment : BaseFragment<FragmentAlbumsBinding>() {
  private val args: AlbumsFragmentArgs by navArgs()
  private val viewModel: AlbumsViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_albums

  override
  fun setBindingVariables() {
    binding.viewModel = viewModel
    viewModel.callService(args.userId)
  }

  override fun setupObservers() {
    super.setupObservers()
    lifecycleScope.launchWhenResumed {
      viewModel.response.collect {
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