package az.sharif.maintask.view.main.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import az.sharif.maintask.R
import az.sharif.maintask.adapter.FragmentPageAdapter
import az.sharif.maintask.databinding.FragmentClubsBinding
import com.google.android.material.tabs.TabLayoutMediator

class ClubsFragment : Fragment(R.layout.fragment_clubs) {

    private lateinit var binding: FragmentClubsBinding
    private lateinit var pageAdapter: FragmentPageAdapter

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentClubsBinding.bind(view)

        pageAdapter = FragmentPageAdapter(requireActivity().supportFragmentManager, lifecycle)

        binding.viewPager.adapter = pageAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = if (position == 0) "Clubs" else "Events"
        }.attach()

    }
}