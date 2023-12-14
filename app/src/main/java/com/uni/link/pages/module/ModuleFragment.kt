package com.uni.link.pages.module

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.uni.link.databinding.FragmentModuleBinding

class ModuleFragment : Fragment() {

    private var _binding: FragmentModuleBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val moduleViewModel =
            ViewModelProvider(this).get(ModuleViewModel::class.java)

        _binding = FragmentModuleBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val textView: TextView = binding.textModule
        moduleViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root


    }


    override fun onDestroyView() {
       super.onDestroyView()
       _binding = null
    }


}