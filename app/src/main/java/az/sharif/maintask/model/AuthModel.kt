package az.sharif.maintask.model

import com.google.gson.annotations.SerializedName

data class AuthModel(
    @SerializedName("access")
    val accessToken: String,
    @SerializedName("refresh")
    val refreshToken: String
)