package az.sharif.maintask.view.registerFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentRegister2Binding

class RegisterFragment2 : Fragment(R.layout.fragment_register2) {

    private lateinit var binding: FragmentRegister2Binding
    private lateinit var navController: NavController
    val players = arrayOf("Messi", "Neymar", "Veratti", "Icardi", "Neymar", "Veratti", "Icardi")
    val players2 = arrayOf("Neymar", "Veratti", "Icardi", "Neymar", "Veratti", "Icardi")
    val players3 = arrayOf("Veratti", "Icardi", "Neymar", "Veratti", "Icardi")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegister2Binding.bind(view)
        navController = Navigation.findNavController(view)

        binding.materialButton2.setOnClickListener {
            navController.popBackStack()
        }
        binding.materialButton3.setOnClickListener {
            navController.navigate(RegisterFragment2Directions.actionRegisterFragment2ToRegisterFragment32())
        }

        val arrayAdapter = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            players
        )
        val arrayAdapter2 = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            players2
        )
        val arrayAdapter3 = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            players3
        )

        binding.spinner.adapter = arrayAdapter
        binding.spinner2.adapter = arrayAdapter2
        binding.spinner3.adapter = arrayAdapter3

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        binding.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }
}