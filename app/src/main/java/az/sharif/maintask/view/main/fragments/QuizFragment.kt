package az.sharif.maintask.view.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentQuizBinding

class QuizFragment : Fragment(R.layout.fragment_quiz) {

    private lateinit var binding: FragmentQuizBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizBinding.bind(view)
    }
}