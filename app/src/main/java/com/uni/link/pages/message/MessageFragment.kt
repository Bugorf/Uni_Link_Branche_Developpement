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
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uni.link.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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


        btn.setOnClickListener {
            // 获取 Firebase 实时数据库的引用
            val database = FirebaseDatabase.getInstance()
            val conversationsRef = database.getReference("conversations")

// 创建一个唯一的聊天会话标识符
            val conversationId = conversationsRef.push().key

// 在 conversations 节点下创建一个聊天会话
            val conversationData = HashMap<String, Any>()
            conversationData["messages"] = HashMap<String, Any>()
            conversationData["participants"] = HashMap<String, Boolean>()

            conversationsRef.child(conversationId!!).setValue(conversationData)






        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}