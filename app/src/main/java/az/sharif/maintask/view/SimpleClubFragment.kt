package az.sharif.maintask.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import az.sharif.maintask.R
import az.sharif.maintask.adapter.ClubPostAdapter
import az.sharif.maintask.databinding.FragmentSimpleClubBinding
import az.sharif.maintask.viewmodel.RecyclerViewModel

class SimpleClubFragment : Fragment(R.layout.fragment_simple_club) {

    private lateinit var binding: FragmentSimpleClubBinding
    private val viewModel: RecyclerViewModel by viewModels()
    private val recyclerAdapter = ClubPostAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSimpleClubBinding.bind(view)

        viewModel.refreshClubs()
        binding.clubsRecycler.adapter = recyclerAdapter
        observeData()
    }

    private fun observeData() {
        viewModel.clubs.observe(viewLifecycleOwner) { clubs ->
            clubs?.let {
                binding.clubsRecycler.visibility = View.VISIBLE
                recyclerAdapter.updateRecyclerList(clubs)
            }
        }
    }

}