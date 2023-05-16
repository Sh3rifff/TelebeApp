package az.sharif.maintask.repositiory

import az.sharif.maintask.model.CourseModel
import az.sharif.maintask.model.TagModel
import az.sharif.maintask.model.UniversityModel
import az.sharif.maintask.service.RetrofitHelper

class RegisterRepository {

    private val service = RetrofitHelper.service

    suspend fun getUnis(): List<UniversityModel> {
        val response = service.uni()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    suspend fun getCourse(): List<CourseModel> {
        val response = service.course()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    suspend fun getTag(): List<TagModel> {
        val response = service.tag()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }
}