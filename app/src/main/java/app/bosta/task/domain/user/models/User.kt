package app.bosta.task.domain.user.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class User(
  @SerializedName("address")
  @Expose val address: Address = Address(),
  @SerializedName("company")
  @Expose val company: Company = Company(),
  @SerializedName("email")
  @Expose val email: String = "",
  @SerializedName("id")
  @Expose val id: Int = 0,
  @SerializedName("name")
  @Expose val name: String = "",
  @SerializedName("phone")
  @Expose val phone: String = "",
  @SerializedName("username")
  @Expose val username: String = "",
  @SerializedName("website")
  @Expose val website: String = ""
) {
  @Keep
  data class Address(
    @SerializedName("city")
    @Expose val city: String = "",
    @SerializedName("geo")
    @Expose val geo: Geo = Geo(),
    @SerializedName("street")
    @Expose val street: String = "",
    @SerializedName("suite")
    @Expose val suite: String = "",
    @SerializedName("zipcode")
    @Expose val zipcode: String = ""
  ) {
    @Keep
    data class Geo(
      @SerializedName("lat")
      @Expose val lat: String = "",
      @SerializedName("lng")
      @Expose val lng: String = ""
    )
  }

  @Keep
  data class Company(
    @SerializedName("bs")
    @Expose val bs: String = "",
    @SerializedName("catchPhrase")
    @Expose val catchPhrase: String = "",
    @SerializedName("name")
    @Expose val name: String = ""
  )
}