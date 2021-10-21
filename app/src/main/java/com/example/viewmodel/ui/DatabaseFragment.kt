package com.example.viewmodel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentDatabaseBinding
import com.example.viewmodel.ui.viewModels.DatabaseViewModel
import com.opinyour.android.app.data.utils.Injection
import kotlinx.android.synthetic.main.fragment_database.*


class DatabaseFragment : Fragment() {
    private lateinit var databaseViewModel: DatabaseViewModel
    private lateinit var binding: FragmentDatabaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        databaseViewModel =
            ViewModelProvider(this, Injection.provideViewModelFactory(requireContext()))
                .get(DatabaseViewModel::class.java)


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_database, container, false)
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_database, container, false)
        binding.viewmodel = databaseViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //TODO: 7. prerobit na databinding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //TODO: 8. nahradit observer databindingom v xml
        //databaseViewModel.words.observe(viewLifecycleOwner) { binding.wordsText.text = it.toString() }

        //TODO: 10. nahradit listener databindingom v xml
        //binding.wordBtn.setOnClickListener { addWord() }
    }

    //TODO: 10. odstanit funkciu pomocou databindingu v xml
//    private fun addWord() {
//        val word = binding.wordInput.text.toString()
//        if (word.isNotEmpty()) {
//            databaseViewModel.insertWord(word)
//            binding.wordInput.text.clear()
//        }
//    }
}
