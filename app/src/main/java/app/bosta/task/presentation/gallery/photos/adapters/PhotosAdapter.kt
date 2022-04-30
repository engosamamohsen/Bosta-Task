package app.bosta.task.presentation.gallery.photos.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.domain.user.models.User
import app.bosta.task.presentation.gallery.photos.viewModels.ItemPhotoViewModel
import app.bosta.task.presentation.users.list.viewModels.ItemUserViewModel
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.ItemPhotoBinding
import com.structure.base_mvvm.databinding.ItemUserBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    var originalList = arrayListOf<Photo>()
    private val differCallback = object : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
      return oldItem == newItem
    }
  }
  val differ = AsyncListDiffer(this, differCallback)
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val data = differ.currentList[position]
    val itemViewModel = ItemPhotoViewModel(data)
    holder.setViewModel(itemViewModel)

  }

  override fun getItemCount(): Int {
    return differ.currentList.size
  }

  override fun onViewAttachedToWindow(holder: ViewHolder) {
    super.onViewAttachedToWindow(holder)
    holder.bind()
  }

  override fun onViewDetachedFromWindow(holder: ViewHolder) {
    super.onViewDetachedFromWindow(holder)
    holder.unBind()
  }

  private val TAG = "PhotosAdapter"
  var lastSearch = ""
  val list = arrayListOf<Photo>()
  fun search(text: String) {
    if(text != lastSearch) {
      lastSearch = text
      list.clear()
      Log.d(TAG, "search: ${text}")
      when {
        text.isNotEmpty() -> {
          originalList.forEach {
            if (it.title.contains(text)) {
              list.add(it)
            }
          }
        }
        else -> list.addAll(originalList)
      }
      differ.submitList(list)
      notifyDataSetChanged()
    }
  }

  inner class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private lateinit var itemLayoutBinding: ItemPhotoBinding

    init {
      bind()
    }

    fun bind() {
      itemLayoutBinding = DataBindingUtil.bind(itemView)!!
    }

    fun unBind() {
      itemLayoutBinding.unbind()
    }

    fun setViewModel(itemViewModel: ItemPhotoViewModel) {
      itemLayoutBinding.itemViewModels = itemViewModel
    }
  }

}