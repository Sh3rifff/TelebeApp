package az.sharif.maintask.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import az.sharif.maintask.R
import az.sharif.maintask.adapter.ClubRecyclerAdapter
import az.sharif.maintask.databinding.FragmentRealClubBinding
import az.sharif.maintask.model.HobbiesModel
import az.sharif.maintask.viewmodel.RecyclerViewModel
import com.google.android.material.chip.Chip

@Suppress("DEPRECATION")
class RealClubFragment : Fragment(R.layout.fragment_real_club) {

    private lateinit var binding: FragmentRealClubBinding
    private val viewModel: RecyclerViewModel by viewModels()
    private val recyclerAdapter = ClubRecyclerAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRealClubBinding.bind(view)

        viewModel.refreshData()
        binding.recyclerView.adapter = recyclerAdapter
        observeData()

        addHobbies()
        filterChips()

    }

    private fun addHobbies() {

        val item1 = HobbiesModel("Piano")
        val item2 = HobbiesModel("Booking")
        val item3 = HobbiesModel("Coding")
        val item4 = HobbiesModel("Skiing")
        val item5 = HobbiesModel("Football")
        val item6 = HobbiesModel("Volleyball")
        val item7 = HobbiesModel("Tennis")
        val item8 = HobbiesModel("Basketball")
        val item9 = HobbiesModel("Carting")

        val data = arrayListOf(
            item1,
            item2,
            item3,
            item4,
            item5,
            item6,
            item7,
            item8,
            item9
        )
        data.forEach {
            creteChips(it.hobbies)
        }
        binding.searchImage.setOnClickListener {
            binding.chipGroup.checkedChipIds.forEach {
                binding.chipGroup.findViewById<Chip>(it).text

                Toast.makeText(
                    requireContext(),
                    binding.chipGroup.findViewById<Chip>(it).text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun creteChips(txt: String) {
        val chip = Chip(requireContext())
        chip.apply {
            text = txt
            chipIcon = ContextCompat.getDrawable(
                requireContext(), R.drawable.ic_launcher_background
            )
            isChipIconVisible = false
            isCheckable = true
            binding.chipGroup.addView(chip as View)
            setOnCloseIconClickListener {
                binding.chipGroup.removeView(chip as View)
            }
        }
    }

    private fun filterChips() {
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip? = group.findViewById(checkedId)
            chip?.chipBackgroundColor = ContextCompat.getColorStateList(
                requireContext(), R.color.purple_200
            )
        }
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