package com.uni.link.pages.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uni.link.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private lateinit var adapter: MsgAdapter
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btn: Button = binding.button2
        val et: EditText = binding.editTextText
        val lv: ListView = binding.lv

        val database = Firebase.database
        val conversationsRef = database.getReference("conversations")
        val t: TextView = binding.textView6
        val idList = mutableListOf<String>()

        adapter = MsgAdapter(requireContext(), idList)
        lv.adapter = adapter

        btn.setOnClickListener {

            val value = et.text.toString()
            conversationsRef.setValue(value)

        }

        conversationsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


                val conId = dataSnapshot.value.toString()
                t.text = conId



            }
            override fun onCancelled(error: DatabaseError) {

            }
        })




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}