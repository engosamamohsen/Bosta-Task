package app.bosta.task.data.users.data_source.remote

import app.bosta.task.domain.gallery.album.Album
import app.bosta.task.domain.gallery.photo.Photo
import app.bosta.task.domain.user.models.User
import app.bosta.task.domain.utils.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersServices {
  @GET("users")
  suspend fun users(): List<User>

  @GET("albums")
  suspend fun albums(
    @Query("userId") id: Int,
  ): List<Album>

  @GET("photos")
  suspend fun photos(
    @Query("albumId") id: Int,
  ): List<Photo>

}