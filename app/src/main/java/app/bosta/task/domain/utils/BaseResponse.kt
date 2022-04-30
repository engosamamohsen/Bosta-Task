package app.bosta.task.domain.utils

data class BaseResponse<T>(
  val data: T,
  val message: String,
  val code: Int,
)