package com.queirozzzzzzzzzz.estufasemestufa.ui.environment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.queirozzzzzzzzzz.estufasemestufa.databinding.FragmentEnvironmentTasksHistoryBinding

class EnvironmentTasksHistoryFragment : Fragment() {
    private var _binding: FragmentEnvironmentTasksHistoryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEnvironmentTasksHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }
}
