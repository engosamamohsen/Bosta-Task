package app.bosta.task.domain.gallery.album

import androidx.annotation.Keep

@Keep
data class Album(
  val id: Int = -1,
  val userId: Int = -1,
  val title: String = ""
)