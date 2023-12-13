package com.uni.link.pages.enregistrement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.uni.link.R
import com.uni.link.databinding.FragmentProfilBinding
import com.uni.link.databinding.SignUpBinding


class Sign_up : Fragment() {

    private var _binding: SignUpBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = Firebase.auth

        _binding = SignUpBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val creerBtn: Button = binding.creerBtn

        val email: EditText = binding.email
        val pass: EditText = binding.pass
        val name: EditText = binding.userName


        creerBtn.setOnClickListener {

            val valueEmail = email.text.toString()
            val valuePass = pass.text.toString()
            val valueName = name.text.toString()

            auth.createUserWithEmailAndPassword(valueEmail, valuePass)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {

                        val user = Firebase.auth.currentUser

                        val profileUpdates = userProfileChangeRequest {
                            displayName = valueName
                        }

                        user!!.updateProfile(profileUpdates)
                            .addOnCompleteListener { task ->

                            }
                    }
                }


            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, Sign_up_finish())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        // Inflate the layout for this fragment
        return root
    }


}