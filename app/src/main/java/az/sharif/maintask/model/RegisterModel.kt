package az.sharif.maintask.model

import com.google.gson.annotations.SerializedName

data class RegisterModel(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password2")
    val confirmPassword: String,
)