package az.sharif.maintask.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentLoginBinding
import az.sharif.maintask.view.activities.MainActivity

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        navController = Navigation.findNavController(view)

        binding.registerText.setOnClickListener {
            navController.navigate(LoginFragmentDirections.loginToRegister())
        }

        binding.materialButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
    }

}