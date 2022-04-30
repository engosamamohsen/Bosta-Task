package app.bosta.task.presentation.gallery.albums.viewModels

import android.view.View
import androidx.databinding.ObservableInt
import androidx.fragment.app.findFragment
import app.bosta.task.domain.gallery.album.Album
import app.bosta.task.domain.user.models.User
import app.bosta.task.presentation.base.BaseViewModel
import app.bosta.task.presentation.base.extensions.navigateSafe
import app.bosta.task.presentation.gallery.albums.AlbumsFragment
import app.bosta.task.presentation.gallery.albums.AlbumsFragmentDirections

class ItemAlbumViewModel constructor(val album: Album) : BaseViewModel() {

  fun submit(v: View){
    v.findFragment<AlbumsFragment>().navigateSafe(AlbumsFragmentDirections.actionAlbumsFragmentToPhotosFragment(album.title,album.id))
  }
}