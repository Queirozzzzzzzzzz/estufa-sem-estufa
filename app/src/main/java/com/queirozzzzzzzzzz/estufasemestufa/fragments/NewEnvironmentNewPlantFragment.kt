package com.queirozzzzzzzzzz.estufasemestufa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.queirozzzzzzzzzz.estufasemestufa.databinding.FragmentNewEnvironmentNewPlantBinding

class NewEnvironmentNewPlantFragment : Fragment() {
    private var _binding: FragmentNewEnvironmentNewPlantBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewEnvironmentNewPlantBinding.inflate(inflater, container, false)
        return binding.root
    }
}