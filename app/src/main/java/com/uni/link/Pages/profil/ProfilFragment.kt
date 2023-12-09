package com.uni.link.Pages.profil

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.uni.link.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: ProfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val profilViewModel = ViewModelProvider(this).get(ProfilViewModel::class.java)
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView
        profilViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}