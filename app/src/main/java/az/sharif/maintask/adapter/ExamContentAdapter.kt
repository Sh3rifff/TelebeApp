package az.sharif.maintask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import az.sharif.maintask.databinding.ExamContenetLayoutBinding
import az.sharif.maintask.model.ExamContentModel

class ExamContentAdapter(private var recyclerList: List<ExamContentModel>) :
    RecyclerView.Adapter<ExamContentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ExamContenetLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.number.text = recyclerList[position].number.toString()
        holder.binding.question.text = recyclerList[position].question
        holder.binding.radio1.text = recyclerList[position].type1
        holder.binding.radio2.text = recyclerList[position].type2
        holder.binding.radio3.text = recyclerList[position].type3
        holder.binding.radio4.text = recyclerList[position].type4
        holder.binding.radio5.text = recyclerList[position].type5
    }

    override fun getItemCount(): Int = recyclerList.size

    class ViewHolder(val binding: ExamContenetLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun updateRecyclerList(newRecyclerList: List<ExamContentModel>) {
        recyclerList = newRecyclerList
        notifyDataSetChanged()
    }
}