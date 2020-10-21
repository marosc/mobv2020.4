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
import com.example.viewmodel.ui.viewModels.MarsViewModel
import com.opinyour.android.app.data.utils.Injection


class MarsFragment : Fragment() {
    private lateinit var marsViewModel: MarsViewModel
    private lateinit var binding: FragmentMarsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_mars, container, false
        )
        binding.lifecycleOwner = this
        marsViewModel = ViewModelProvider(this, Injection.provideViewModelFactory(requireContext()))
            .get(MarsViewModel::class.java)

        binding.model = marsViewModel

        binding.imageList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        //binding.wordsList.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,true)
        //binding.wordsList.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        //binding.wordsList.layoutManager = GridLayoutManager(context,3,RecyclerView.VERTICAL,false)

        val adapter = MarsAdapter()
        binding.imageList.adapter = adapter
        marsViewModel.images.observe(viewLifecycleOwner) { adapter.data = it }

        return binding.root
    }
}
