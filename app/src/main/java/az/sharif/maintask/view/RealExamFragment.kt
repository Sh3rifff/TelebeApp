package az.sharif.maintask.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.adapter.ExamContentAdapter
import az.sharif.maintask.databinding.FragmentRealExamBinding
import az.sharif.maintask.viewmodel.RecyclerViewModel

class RealExamFragment : Fragment(R.layout.fragment_real_exam) {

    private lateinit var binding: FragmentRealExamBinding
    private lateinit var navController: NavController
    private val viewModel: RecyclerViewModel by viewModels()
    private val examAdapter = ExamContentAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRealExamBinding.bind(view)
        navController = Navigation.findNavController(view)

        viewModel.refreshExamContent()
        binding.recyclerView.adapter = examAdapter
        observeData()
    }

    private fun observeData() {
        viewModel.examContent.observe(viewLifecycleOwner) { examContent ->
            examContent?.let {
                binding.recyclerView.visibility = View.VISIBLE
                examAdapter.updateRecyclerList(examContent)
            }
        }
    }
}