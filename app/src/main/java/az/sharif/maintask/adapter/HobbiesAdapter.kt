package az.sharif.maintask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import az.sharif.maintask.databinding.HobbiesLayoutBinding
import az.sharif.maintask.model.HobbiesModel

class HobbiesAdapter(private var hobbiesList: List<HobbiesModel>) :
    RecyclerView.Adapter<HobbiesAdapter.ViewHolder>() {

    class ViewHolder(val binding: HobbiesLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            HobbiesLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HobbiesAdapter.ViewHolder(binding)
    }

    override fun getItemCount(): Int = hobbiesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.hobbies.text = hobbiesList[position].hobbies
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecyclerList(newRecyclerList: List<HobbiesModel>) {
        hobbiesList = newRecyclerList
        notifyDataSetChanged()
    }
}