package com.uni.link.pages.enregistrement

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.uni.link.MainActivity
import com.uni.link.R
import com.uni.link.databinding.SignUpBinding
import com.uni.link.databinding.SignUpFinishBinding


class Sign_up_finish : Fragment() {

    private var _binding: SignUpFinishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = SignUpFinishBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textV: TextView = binding.textView5
        textV.setText("Votre inscription est terminée \n\n Veuillez vous connecter")

        val btn:Button = binding.valideBtn
        btn.setOnClickListener {
            val intent = Intent (requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }

        return root
    }


}