package com.queirozzzzzzzzzz.estufasemestufa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.queirozzzzzzzzzz.estufasemestufa.databinding.FragmentEditEnvironmentEditPlantBinding

class EditEnvironmentEditPlantFragment : Fragment() {
    private var _binding: FragmentEditEnvironmentEditPlantBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditEnvironmentEditPlantBinding.inflate(inflater, container, false)
        return binding.root
    }
}