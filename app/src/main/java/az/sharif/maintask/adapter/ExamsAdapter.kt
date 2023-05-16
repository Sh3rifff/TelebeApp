package az.sharif.maintask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import az.sharif.maintask.databinding.ExamLayoutBinding
import az.sharif.maintask.model.ExamsModel
import az.sharif.maintask.view.QuizOpeningFragmentDirections

class ExamsAdapter(private var recyclerList: List<ExamsModel>) :
    RecyclerView.Adapter<ExamsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ExamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemName.text = recyclerList[position].name
        holder.binding.uniName.text = recyclerList[position].uni
        holder.binding.count.text = recyclerList[position].count.toString()
        holder.itemView.setOnClickListener {
            val action = QuizOpeningFragmentDirections.openToReal()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int = recyclerList.size

    class ViewHolder(val binding: ExamLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecyclerList(newRecyclerList: List<ExamsModel>) {
        recyclerList = newRecyclerList
        notifyDataSetChanged()
    }
}