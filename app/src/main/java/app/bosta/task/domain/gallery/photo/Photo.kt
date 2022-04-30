package app.bosta.task.domain.gallery.photo

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Photo(
  val id: Int = -1,
  val title: String = "",
  val url: String = "",
  var thumbnailUrl: String = ""
): Serializable