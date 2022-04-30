package app.bosta.task.data.users.repository

import app.bosta.task.data.users.data_source.remote.UsersRemoteDataSource
import app.bosta.task.domain.gallery.album.Album
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.domain.user.models.User
import app.bosta.task.domain.user.repository.UsersRepository
import app.bosta.task.domain.utils.BaseResponse
import app.bosta.task.domain.utils.Resource
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val remoteDataSource: UsersRemoteDataSource) :
  UsersRepository {
  override suspend fun users(): Resource<List<User>> = remoteDataSource.users()
  override suspend fun albums(userId: Int): Resource<List<Album>> = remoteDataSource.albums(userId)
  override suspend fun photos(albumId: Int): Resource<List<Photo>> = remoteDataSource.photos(albumId)

}