package az.sharif.maintask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import az.sharif.maintask.databinding.RecyclerviewItemBinding
import az.sharif.maintask.model.RecyclerModel

class EventRecyclerAdapter(private var recyclerList: List<RecyclerModel>) :
    RecyclerView.Adapter<EventRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = recyclerList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemName.text = recyclerList[position].name
        holder.binding.imageView.setImageResource(recyclerList[position].image)
    }

    class ViewHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecyclerList(newRecyclerList: List<RecyclerModel>) {
        recyclerList = newRecyclerList
        notifyDataSetChanged()
    }


}