package az.sharif.maintask.view.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

    }
}