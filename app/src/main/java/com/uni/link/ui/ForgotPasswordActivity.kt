package com.uni.link.ui

import LoginActivity
import com.uni.link.R
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ForgotPasswordActivity {

    class ForgotPasswordActivity : AppCompatActivity() {
        private var emailEditText: EditText? = null
        private var submitButton: Button? = null
        private var loginTextView: TextView? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.forgot_password_activity)
            emailEditText = findViewById<EditText>(R.id.emailEditText)
            submitButton = findViewById<Button>(R.id.submitButton)
            loginTextView = findViewById<TextView>(R.id.loginTextView)
            submitButton?.setOnClickListener(View.OnClickListener {
                val email = emailEditText?.getText().toString().trim { it <= ' ' }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailEditText?.setError("Please enter a valid email")
                    emailEditText?.requestFocus()
                    return@OnClickListener
                }

                // Logic to send an email to the user with a password reset link
                sendPasswordResetEmail(email)
            })
            loginTextView?.setOnClickListener(View.OnClickListener {
                startActivity(
                    Intent(
                        this@ForgotPasswordActivity,
                        LoginActivity::class.java
                    )
                )
            })
        }

        private fun sendPasswordResetEmail(email: String) {
            // Your implementation here
        }
    }

}