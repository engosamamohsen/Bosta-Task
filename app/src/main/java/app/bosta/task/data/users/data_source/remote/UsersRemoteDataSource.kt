package app.bosta.task.data.users.data_source.remote

import app.bosta.task.data.remote.BaseRemoteDataSource
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(private val apiService: UsersServices) :
  BaseRemoteDataSource() {
  suspend fun users() = safeApiCall {
    apiService.users()
  }

  suspend fun albums(userId: Int) = safeApiCall {
    apiService.albums(userId)
  }

  suspend fun photos(albumId: Int) = safeApiCall {
    apiService.photos(albumId)
  }

}