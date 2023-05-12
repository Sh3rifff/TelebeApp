package az.sharif.maintask.view.registerFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColorStateList
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentRegister3Binding
import az.sharif.maintask.model.HobbiesModel
import az.sharif.maintask.view.activities.MainActivity
import com.google.android.material.chip.Chip

@Suppress("DEPRECATION")
class RegisterFragment3 : Fragment(R.layout.fragment_register3) {

    private lateinit var binding: FragmentRegister3Binding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegister3Binding.bind(view)
        navController = Navigation.findNavController(view)

        binding.materialButton.setOnClickListener {
            navController.popBackStack()
        }

        binding.materialButton3.setOnClickListener {

        }

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
        binding.materialButton3.setOnClickListener {
            binding.chipGroup.checkedChipIds.forEach {
                binding.chipGroup.findViewById<Chip>(it).text

                Toast.makeText(
                    requireContext(),
                    binding.chipGroup.findViewById<Chip>(it).text,
                    Toast.LENGTH_SHORT
                ).show()
            }
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
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
            chip?.chipBackgroundColor = getColorStateList(
                requireContext(), R.color.purple_200
            )
        }
    }

}