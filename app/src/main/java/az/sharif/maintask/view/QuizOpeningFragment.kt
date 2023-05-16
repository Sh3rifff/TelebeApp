package az.sharif.maintask.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.adapter.ExamsAdapter
import az.sharif.maintask.databinding.FragmentQuizOpeningBinding
import az.sharif.maintask.viewmodel.RecyclerViewModel

class QuizOpeningFragment : Fragment(R.layout.fragment_quiz_opening) {

    private lateinit var binding: FragmentQuizOpeningBinding
    private lateinit var navController: NavController
    private val viewModel: RecyclerViewModel by viewModels()
    private val examAdapter = ExamsAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizOpeningBinding.bind(view)
        navController = Navigation.findNavController(view)

        viewModel.refreshExams()
        binding.recyclerView.adapter = examAdapter
        observeData()
    }

    private fun observeData() {
        viewModel.exams.observe(viewLifecycleOwner) { exams ->
            exams?.let {
                binding.recyclerView.visibility = View.VISIBLE
                examAdapter.updateRecyclerList(exams)
            }
        }
    }
}