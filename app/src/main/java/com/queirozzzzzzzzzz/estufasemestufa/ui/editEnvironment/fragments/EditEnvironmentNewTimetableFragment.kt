package com.queirozzzzzzzzzz.estufasemestufa.ui.editEnvironment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.queirozzzzzzzzzz.estufasemestufa.databinding.FragmentEditEnvironmentNewTimetableBinding

class EditEnvironmentNewTimetableFragment : Fragment() {
    private var _binding: FragmentEditEnvironmentNewTimetableBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEditEnvironmentNewTimetableBinding.inflate(inflater, container, false)
        return binding.root
    }
}