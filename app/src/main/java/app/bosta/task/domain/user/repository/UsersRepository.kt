package app.bosta.task.domain.user.repository
import app.bosta.task.domain.gallery.album.Album
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.domain.user.models.User
import app.bosta.task.domain.utils.Resource

interface UsersRepository {
  suspend fun users(): Resource<List<User>>
  suspend fun albums(userId: Int): Resource<List<Album>>
  suspend fun photos(albumId: Int): Resource<List<Photo>>
}