package com.uni.link.Pages.partage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.uni.link.Pages.home.HomeFragment
import com.uni.link.Pages.module.ModuleViewModel
import com.uni.link.R
import com.uni.link.databinding.FragmentModuleBinding
import com.uni.link.databinding.FragmentPartageBinding

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

        val textView: TextView = binding.textView
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val imageButton: ImageButton = binding.imageButton2
        imageButton.setOnClickListener() {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.home_frag, HomeFragment())
            transaction.commit()
        }
        return root
    }


}