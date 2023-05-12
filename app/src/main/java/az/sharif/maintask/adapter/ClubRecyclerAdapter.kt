package az.sharif.maintask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import az.sharif.maintask.databinding.ClubRecyclerItemBinding
import az.sharif.maintask.model.RecyclerModel
import az.sharif.maintask.view.main.fragments.ClubsFragmentDirections

class ClubRecyclerAdapter(private var recyclerList: List<RecyclerModel>) :
    RecyclerView.Adapter<ClubRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ClubRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemName.text = recyclerList[position].name
        holder.binding.imageView.setImageResource(recyclerList[position].image)
        holder.itemView.setOnClickListener {
            val action = ClubsFragmentDirections.clubToSimple()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int = recyclerList.size


    class ViewHolder(val binding: ClubRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecyclerList(newRecyclerList: List<RecyclerModel>) {
        recyclerList = newRecyclerList
        notifyDataSetChanged()
    }
}