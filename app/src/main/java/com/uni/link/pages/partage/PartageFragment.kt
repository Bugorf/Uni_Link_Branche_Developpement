package com.uni.link.pages.partage

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.uni.link.MainActivity
import com.uni.link.R
import com.uni.link.databinding.FragmentPartageBinding
import com.uni.link.pages.home.HomeFragment

class PartageFragment : Fragment() {

    private var _binding: FragmentPartageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel =
            ViewModelProvider(this).get(PartageViewModel::class.java)

        _binding = FragmentPartageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView2
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val imageButton: ImageButton = binding.imageButton2
        imageButton.setOnClickListener() {

            val intent = Intent (requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
        return root
    }


}