package az.sharif.maintask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import az.sharif.maintask.R
import az.sharif.maintask.model.ClubPostModel
import az.sharif.maintask.model.RecyclerModel

class RecyclerViewModel : ViewModel() {

    val recyclers = MutableLiveData<List<RecyclerModel>>()
    val clubs = MutableLiveData<List<ClubPostModel>>()

    fun refreshData() {

        val item1 = RecyclerModel("Android Development", R.drawable.music)
        val item2 = RecyclerModel("Back-end Development", R.drawable.music)
        val item3 = RecyclerModel("Item2", R.drawable.music)
        val item4 = RecyclerModel("Item2", R.drawable.music)
        val item5 = RecyclerModel("Item2", R.drawable.music)

        val data = arrayListOf(item1, item2, item3, item4, item5)

        recyclers.value = data
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