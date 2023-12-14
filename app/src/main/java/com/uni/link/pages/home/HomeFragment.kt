package com.uni.link.pages.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.uni.link.R
import com.uni.link.databinding.FragmentHomeBinding
import com.uni.link.pages.cardsintents.CodecActivity
import com.uni.link.pages.cardsintents.IntelligenceArtificielleActivity
import com.uni.link.pages.cardsintents.JavaActivity
import com.uni.link.pages.cardsintents.LangageAssembleurActivity
import com.uni.link.pages.partage.PartageFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // TODO
        binding.cardC.setOnClickListener {
            val intent = Intent(context, CodecActivity::class.java)
            startActivity(intent)
        }

        // TODO
        binding.cardIA.setOnClickListener {
            val intent = Intent(context, IntelligenceArtificielleActivity::class.java)
            startActivity(intent)
        }

        binding.cardJava.setOnClickListener {
            val intent = Intent(context, JavaActivity::class.java)
            startActivity(intent)
        }

        binding.cardLangageAssembleur.setOnClickListener {
            val intent = Intent(context,LangageAssembleurActivity::class.java)
            startActivity(intent)
        }

        val imageButton: ImageButton = binding.imageButton
        imageButton.setOnClickListener() {

            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, PartageFragment())
            transaction.addToBackStack(null)
            transaction.commit()

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}