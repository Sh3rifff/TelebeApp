package az.sharif.maintask.service

import az.sharif.maintask.model.AuthModel
import az.sharif.maintask.model.CourseModel
import az.sharif.maintask.model.LoginModel
import az.sharif.maintask.model.RegisterModel
import az.sharif.maintask.model.TagModel
import az.sharif.maintask.model.UniversityModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login/")
    fun login(@Body loginData: LoginModel): Call<AuthModel>

    @POST("auth/register/")
    fun register(@Body loginData: RegisterModel): Call<RegisterModel>

    @GET("university/")
    suspend fun uni(): Response<List<UniversityModel>>

    //update
    @GET("specialty/")
    suspend fun course(): Response<List<CourseModel>>

    @GET("tag/")
    suspend fun tag(): Response<List<TagModel>>

}