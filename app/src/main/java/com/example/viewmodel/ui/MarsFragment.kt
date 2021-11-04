package com.example.viewmodel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentMarsBinding
import com.example.viewmodel.ui.adapter.MarsAdapter
import com.example.viewmodel.ui.viewModels.MarsViewModel
import com.opinyour.android.app.data.utils.Injection

class MarsFragment : Fragment() {
    private lateinit var binding: FragmentMarsBinding
    private lateinit var viewModel: MarsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mars, container, false)

        viewModel = ViewModelProvider(
            this,
            Injection.provideViewModelFactory(requireContext())
        )
            .get(MarsViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        //RecyclerView
        binding.showMars.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        val adapter = MarsAdapter()
        binding.showMars.adapter = adapter

        viewModel.images.observe(viewLifecycleOwner) {
            adapter.updateData(it)
//            adapter.items = it
        }

        return binding.root
    }
}