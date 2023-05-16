package az.sharif.maintask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import az.sharif.maintask.R
import az.sharif.maintask.model.ClubPostModel
import az.sharif.maintask.model.ExamContentModel
import az.sharif.maintask.model.ExamsModel
import az.sharif.maintask.model.RecyclerModel

class RecyclerViewModel : ViewModel() {

    val recyclers = MutableLiveData<List<RecyclerModel>>()
    val clubs = MutableLiveData<List<ClubPostModel>>()
    val exams = MutableLiveData<List<ExamsModel>>()
    val examContent = MutableLiveData<List<ExamContentModel>>()

    fun refreshData() {

        val item1 = RecyclerModel("Android Development", R.drawable.music)
        val item2 = RecyclerModel("Back-end Development", R.drawable.music)
        val item3 = RecyclerModel("Item2", R.drawable.music)
        val item4 = RecyclerModel("Item2", R.drawable.music)
        val item5 = RecyclerModel("Item2", R.drawable.music)

        val data = arrayListOf(item1, item2, item3, item4, item5)

        recyclers.value = data
    }

    fun refreshExamContent() {

        val item1 = ExamContentModel(1, ".How many page in book ?", "1", "2", "3", "48", "5")
        val item2 = ExamContentModel(2, ".How many page in news ?", "6", "7", "8", "97", "104")
        val item3 = ExamContentModel(3, ".How much page in book ?", "11", "24", "37", "46", "53")
        val item4 = ExamContentModel(4, ".How many page in book ?", "12", "25", "38", "43", "51")
        val item5 = ExamContentModel(5, ".How many page in book ?", "13", "26", "34", "41", "52")

        val data = arrayListOf(item1, item2, item3, item4, item5)

        examContent.value = data
    }

    fun refreshExams() {

        val item1 = ExamsModel("Artificial Intelligence", "Baku Engineering University", 15)
        val item2 = ExamsModel("Graphic Design", "Baku State University", 24)
        val item3 = ExamsModel("Mulki Mudafie", "Baki Slavyan Universiteti", 30)
        val item4 = ExamsModel("None", "None", 20)
        val item5 = ExamsModel("None", "None", 18)

        val data = arrayListOf(item1, item2, item3, item4, item5)

        exams.value = data
    }

    fun refreshClubs() {

        val item1 = ClubPostModel(
            R.drawable.music,
            "Sharif Shiraliyev",
            "Bugun 21:00",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since"
        )
        val item2 = ClubPostModel(
            R.drawable.music, "Elmir Necefov", "Bugun 21:00", R.string.lorem.toString()
        )
        val item3 = ClubPostModel(
            R.drawable.music, "Sharif Shiraliyev", "Bugun 21:00", R.string.lorem.toString()
        )
        val item4 = ClubPostModel(
            R.drawable.music, "Sharif Shiraliyev", "Bugun 21:00", R.string.lorem.toString()
        )
        val item5 = ClubPostModel(
            R.drawable.music, "Sharif Shiraliyev", "Bugun 21:00", R.string.lorem.toString()
        )

        val data = arrayListOf(item1, item2, item3, item4, item5)

        clubs.value = data
    }
}