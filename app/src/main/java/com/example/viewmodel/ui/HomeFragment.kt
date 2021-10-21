package com.example.viewmodel.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentHomeBinding
import com.example.viewmodel.ui.viewModels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)

        //TODO: 1. prerobit na databinding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO: 2. nahradit observer databindingom v xml
        //homeViewModel.word.observe(viewLifecycleOwner) { binding.wordsText.text = it }

        //TODO: 5. nahradit listener databindingom v xml
        //binding.wordBtn.setOnClickListener { changeWord() }

        //TODO: 6. umoznit navigaciu do DatabaseFragmentu po stlaceni tlacidla

        homeViewModel.transformovanyInput.observe(viewLifecycleOwner){
            Log.d("nasa-premenna","je $it")
        }

        binding.databaseBtn.setOnClickListener { it.findNavController().navigate(R.id.go_to_database) }
    }

//    //TODO: 5. odstanit funkciu pomocou databindingu v xml
//    private fun changeWord() {
//        val word = binding.wordInput.text.toString()
//        if (word.isNotEmpty()) {
//            homeViewModel.changeWord(word)
//            binding.wordInput.text.clear()
//        }
//    }
}
