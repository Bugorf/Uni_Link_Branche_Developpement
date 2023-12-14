package com.uni.link

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.widget.Toast



class S : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profil)

        val email: EditText = findViewById(R.id.email)
        val pass: EditText = findViewById(R.id.pass)
        val connecBtn: Button = findViewById(R.id.connecBtn)
        val creerBtn: Button = findViewById(R.id.creerBTN)



        creerBtn.setOnClickListener {

        }

        connecBtn.setOnClickListener {
            val valueEmail = email.text.toString()
            val valuePass = pass.text.toString()

            auth.signInWithEmailAndPassword(valueEmail, valuePass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)
                    } else {

                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        updateUI(null)
                    }
                }

        }
    }

    private fun reload() {
    }

    private fun updateUI(user: FirebaseUser?) {
        val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = it.displayName
            val email = it.email

            val t: TextView = findViewById(R.id.textView3)
            t.setText(email)
        }
    }
}
