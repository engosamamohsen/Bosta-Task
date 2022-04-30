package app.bosta.task.presentation.gallery.image

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import app.bosta.task.presentation.base.BaseFragment
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.FragmentZoomBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ZoomFragment : BaseFragment<FragmentZoomBinding>() {

  val args : ZoomFragmentArgs by navArgs()
  private val viewModel: ZoomViewModel by viewModels()

  override
  fun getLayoutId() = R.layout.fragment_zoom

  override
  fun setBindingVariables() {
    viewModel.setData(args.photo)
    binding.viewModel = viewModel
  }

  override fun onStop() {
    super.onStop()
  }

  override fun onPause() {
    super.onPause()
  }

}