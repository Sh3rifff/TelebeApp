package az.sharif.maintask.view.registerFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentRegister1Binding

class RegisterFragment1 : Fragment(R.layout.fragment_register1) {

    private lateinit var binding: FragmentRegister1Binding
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegister1Binding.bind(view)
        navController = Navigation.findNavController(view)

        binding.materialButton.setOnClickListener {
            navController.navigate(RegisterFragment1Directions.actionRegisterFragmentToRegisterFragment2())
        }
    }
}