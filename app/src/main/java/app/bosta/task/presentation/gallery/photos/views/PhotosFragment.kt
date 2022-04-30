package app.bosta.task.presentation.gallery.photos.views

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import app.bosta.task.domain.utils.Resource
import com.structure.base_mvvm.R
import app.bosta.task.presentation.base.BaseFragment
import app.bosta.task.presentation.base.extensions.handleApiError
import app.bosta.task.presentation.base.extensions.hideKeyboard
import app.bosta.task.presentation.gallery.photos.viewModels.PhotosViewModel
import com.structure.base_mvvm.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding>() {
  private val args: PhotosFragmentArgs by navArgs()
  private val viewModel: PhotosViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_photos

  override
  fun setBindingVariables() {
    binding.viewModel = viewModel
    viewModel.callService(args.albumId)
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