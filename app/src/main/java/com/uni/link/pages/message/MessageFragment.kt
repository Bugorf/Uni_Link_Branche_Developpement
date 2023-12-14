package com.uni.link.pages.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

import android.widget.Toast

import androidx.fragment.app.Fragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uni.link.databinding.FragmentMessageBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private lateinit var adapter: MsgAdapter
    private val binding get() = _binding!!

    val database = Firebase.database("https://uni-link-e5ad5-default-rtdb.europe-west1.firebasedatabase.app")
    val conversationsRef = database.getReference("conversations")

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
        adapter = MsgAdapter(requireActivity(), mutableListOf())
        lv.adapter = adapter

        val conId = conversationsRef.push().key!!
        createConversation(conId, listOf("boy","gril"))

        btn.setOnClickListener {
            val user = Firebase.auth.currentUser!!
            user.let {
                val name = user.displayName.toString()
                val value = et.text.toString()
                val conId = conversationsRef.push().key!!

            }
        }

        // Read from the database
        conversationsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString()
                adapter.add(value)
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        return root
    }

    fun createConversation(conversationId: String, participants: List<String>) {
        val conversationData = HashMap<String, Any>()
        for (c in participants) {
            conversationData[c] = true
        }
        conversationsRef.child(conversationId).child("participant").setValue(conversationData)
    }

    fun addMessage(conversationId: String, msgId:String, msg: Msg) {
        val messageData = HashMap<String, Any>()
        messageData["senderId"] = "1"
        messageData["content"] = "2"
        messageData["timestamp"] = "3"
        conversationsRef.child(conversationId).child("message").child("1").setValue(messageData)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}