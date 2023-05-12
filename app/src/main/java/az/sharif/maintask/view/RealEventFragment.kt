package az.sharif.maintask.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import az.sharif.maintask.R
import az.sharif.maintask.adapter.EventRecyclerAdapter
import az.sharif.maintask.databinding.FragmentRealEventBinding
import az.sharif.maintask.viewmodel.RecyclerViewModel

class RealEventFragment : Fragment(R.layout.fragment_real_event) {

    private lateinit var binding: FragmentRealEventBinding
    private val viewModel: RecyclerViewModel by viewModels()
    private val recyclerAdapter = EventRecyclerAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRealEventBinding.bind(view)

        viewModel.refreshData()
        binding.recyclerView.adapter = recyclerAdapter
        observeData()

    }

    private fun observeData() {
        viewModel.recyclers.observe(viewLifecycleOwner) { recycler ->
            recycler?.let {
                binding.recyclerView.visibility = View.VISIBLE
                recyclerAdapter.updateRecyclerList(recycler)
            }
        }
    }
}