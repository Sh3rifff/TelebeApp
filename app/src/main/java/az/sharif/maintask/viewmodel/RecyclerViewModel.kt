package az.sharif.maintask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import az.sharif.maintask.R
import az.sharif.maintask.model.RecyclerModel

class RecyclerViewModel : ViewModel() {

    val recyclers = MutableLiveData<List<RecyclerModel>>()

    fun refreshData() {

        val item1 = RecyclerModel("Item1", "ItemCategory", R.drawable.ic_recycler)
        val item2 = RecyclerModel("Item2", "ItemCategory2", R.drawable.ic_empty)
        val item3 = RecyclerModel("Item2", "ItemCategory3", R.drawable.ic_news)

        val data = arrayListOf(item1, item2, item3)

        recyclers.value = data
    }
}