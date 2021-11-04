package com.example.viewmodel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentMarsDetialBinding
import com.example.viewmodel.ui.viewModels.MarsViewModel
import com.opinyour.android.app.data.utils.Injection

class MarsDetailFragment : Fragment() {
    private lateinit var binding: FragmentMarsDetialBinding
    private lateinit var viewModel: MarsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mars_detial, container, false)

        viewModel = ViewModelProvider(
            requireActivity(),
            Injection.provideViewModelFactory(requireContext())
        )
            .get(MarsViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }
}