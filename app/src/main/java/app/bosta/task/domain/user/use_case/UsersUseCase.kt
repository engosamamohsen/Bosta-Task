package app.bosta.task.domain.user.use_case

import app.bosta.task.domain.gallery.album.Album
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.domain.user.models.User
import app.bosta.task.domain.user.repository.UsersRepository
import app.bosta.task.domain.utils.BaseResponse
import app.bosta.task.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class UsersUseCase @Inject constructor(
  private val usersRepository: UsersRepository
) {

  operator fun invoke(): Flow<Resource<List<User>>> =
    flow {
      emit(Resource.Loading)
      val result = usersRepository.users()
      emit(result)
    }.flowOn(Dispatchers.IO)

  fun albums(userId: Int): Flow<Resource<List<Album>>> =
    flow {
      emit(Resource.Loading)
      val result = usersRepository.albums(userId)
      emit(result)
    }.flowOn(Dispatchers.IO)

  fun photos(albumId: Int): Flow<Resource<List<Photo>>> =
    flow {
      emit(Resource.Loading)
      val result = usersRepository.photos(albumId)
      emit(result)
    }.flowOn(Dispatchers.IO)
}