package az.sharif.maintask.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//ApiService
object RetrofitHelper {

    private const val BASE_URL = "https://studenthub.herokuapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ApiService::class.java)

}