package az.sharif.maintask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.sharif.maintask.repositiory.RegisterRepository
import az.sharif.maintask.model.CourseModel
import az.sharif.maintask.model.TagModel
import az.sharif.maintask.model.UniversityModel
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repository = RegisterRepository()
    val universityData = MutableLiveData<List<UniversityModel>>()
    val courseData = MutableLiveData<List<CourseModel>>()
    val tagData = MutableLiveData<List<TagModel>>()

    fun getUniFromAPI() {
        viewModelScope.launch {
            universityData.value = repository.getUnis()
        }
    }

    fun getCourseFromAPI() {
        viewModelScope.launch {
            courseData.value = repository.getCourse()
        }
    }

    fun getTagFromAPI() {
        viewModelScope.launch {
            tagData.value = repository.getTag()
        }
    }
}