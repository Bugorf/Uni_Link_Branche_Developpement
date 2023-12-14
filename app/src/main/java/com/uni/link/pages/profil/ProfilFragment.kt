package com.uni.link.pages.profil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.uni.link.R
import com.uni.link.databinding.FragmentProfilBinding
import com.uni.link.databinding.LoginBinding
import com.uni.link.pages.enregistrement.Sign_up

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    private var _binding2: LoginBinding? = null
    private val binding2 get() = _binding2!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = Firebase.auth



        val currentUser = auth.currentUser
        if (currentUser != null) {

            _binding2 = LoginBinding.inflate(inflater, container, false)
            val root: View = binding2.root

            val textView: TextView = binding2.ok
            val btn: Button = binding2.button

            val user = Firebase.auth.currentUser
            user?.let {

                val name = it.displayName
                textView.setText("Bienveunu: $name")
            }
            btn.setOnClickListener {
                auth.signOut()
                update()
            }


            return root
        } else {
            _binding = FragmentProfilBinding.inflate(inflater, container, false)
            val root: View = binding.root

            val email: EditText = binding.email
            val pass: EditText = binding.pass
            val connecBtn: Button = binding.connecBtn
            val creerBtn: Button = binding.creerBTN

            val t: TextView = binding.textView3

            creerBtn.setOnClickListener {
                val fragmentManager = requireActivity().supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.container, Sign_up())
                transaction.addToBackStack(null)
                transaction.commit()
            }

            connecBtn.setOnClickListener {
                val valueEmail = email.text.toString()
                val valuePass = pass.text.toString()

                auth.signInWithEmailAndPassword(valueEmail, valuePass)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            update()
                        } else {

                        }
                    }


            }
            return root

        }







    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun update() {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, ProfilFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

}