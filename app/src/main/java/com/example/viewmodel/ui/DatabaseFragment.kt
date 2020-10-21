package com.example.viewmodel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentDatabaseBinding
import com.example.viewmodel.ui.viewModels.DatabaseViewModel
import com.opinyour.android.app.data.utils.Injection


class DatabaseFragment : Fragment() {
    private lateinit var databaseViewModel: DatabaseViewModel
    private lateinit var binding: FragmentDatabaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_database, container, false
        )
        binding.lifecycleOwner = this
        databaseViewModel =
            ViewModelProvider(this, Injection.provideViewModelFactory(requireContext()))
                .get(DatabaseViewModel::class.java)

        binding.model = databaseViewModel

        //binding.wordsList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        //binding.wordsList.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,true)
//        binding.wordsList.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        binding.wordsList.layoutManager =
            GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)

        val adapter = MessagesAdapter()
        binding.wordsList.adapter = adapter
        databaseViewModel.words.observe(viewLifecycleOwner) { adapter.data = it }


        return binding.root
    }
}
