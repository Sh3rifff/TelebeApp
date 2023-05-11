package az.sharif.maintask.view.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentClubsBinding

class ClubsFragment : Fragment(R.layout.fragment_clubs) {

    private lateinit var binding: FragmentClubsBinding
//    private val viewModel: RecyclerViewModel by viewModels()
//    private val recyclerAdapter = RecyclerAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentClubsBinding.bind(view)

//        viewModel.refreshData()
//        binding.recyclerView.adapter = recyclerAdapter
//        observeData()

    }

//    private fun observeData() {
//        viewModel.recyclers.observe(viewLifecycleOwner) { recycler ->
//            recycler?.let {
//                binding.recyclerView.visibility = View.VISIBLE
//                recyclerAdapter.updateRecyclerList(recycler)
//            }
//        }
//    }
}