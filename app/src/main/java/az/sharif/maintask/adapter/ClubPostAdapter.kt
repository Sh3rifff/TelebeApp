package az.sharif.maintask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import az.sharif.maintask.databinding.ClubContentRecycleBinding
import az.sharif.maintask.model.ClubPostModel

class ClubPostAdapter(private var recyclerList: List<ClubPostModel>) :
    RecyclerView.Adapter<ClubPostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ClubContentRecycleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.content.text = recyclerList[position].content
        holder.binding.textName.text = recyclerList[position].name
        holder.binding.textTime.text = recyclerList[position].time
        holder.binding.clubProfile.setImageResource(recyclerList[position].profileImage)
    }

    override fun getItemCount(): Int = recyclerList.size

    class ViewHolder(val binding: ClubContentRecycleBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecyclerList(newRecyclerList: List<ClubPostModel>) {
        recyclerList = newRecyclerList
        notifyDataSetChanged()
    }
}