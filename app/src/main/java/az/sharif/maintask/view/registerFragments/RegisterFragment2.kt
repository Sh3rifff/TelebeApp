package az.sharif.maintask.view.registerFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentRegister2Binding
import az.sharif.maintask.viewmodel.RegisterViewModel

class RegisterFragment2 : Fragment(R.layout.fragment_register2) {

    private lateinit var binding: FragmentRegister2Binding
    private lateinit var navController: NavController
    private val viewModel: RegisterViewModel by viewModels()

    private var course = arrayOf("--Course", "I", "II", "III", "IV", "V")
    private val adapter3 by lazy {
        ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            course
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegister2Binding.bind(view)
        navController = Navigation.findNavController(view)

        viewModel.getUniFromAPI()
        viewModel.getCourseFromAPI()

        navigation()
        spinners()
        loadData()
        loadData2()
    }

    private fun spinners() {

        binding.spinner3.adapter = adapter3

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

    private fun navigation() {
        binding.materialButton2.setOnClickListener {
            navController.popBackStack()
        }
        binding.materialButton3.setOnClickListener {
            navController.navigate(RegisterFragment2Directions.actionRegisterFragment2ToRegisterFragment32())
        }
    }

    private fun loadData() {

        viewModel.universityData.observe(viewLifecycleOwner) { unis ->

            val def = "--Select Uni"
            val universities = listOf(def) + unis.map { it.university }
            val adapter = ArrayAdapter(
                requireContext(),
                androidx.transition.R.layout.support_simple_spinner_dropdown_item,
                universities
            )
            binding.spinner.adapter = adapter
            adapter.notifyDataSetChanged()

        }
    }

    private fun loadData2() {

        viewModel.courseData.observe(viewLifecycleOwner) { courses ->

            val def = "--Faculty"
            val course = listOf(def) + courses.map { it.title }
            val adapter2 = ArrayAdapter(
                requireContext(),
                androidx.transition.R.layout.support_simple_spinner_dropdown_item,
                course
            )

            adapter2.notifyDataSetChanged()
            binding.spinner2.adapter = adapter2
            adapter2.notifyDataSetChanged()

        }
    }
}