package com.vanlang.kiemtra_laptrinhungdungdidong_2474802010085

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ các View bằng findViewById
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvResult = findViewById(R.id.tvResult)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() -> {
                    tvResult.text = getString(R.string.error_enter_email)
                }

                password.isEmpty() -> {
                    tvResult.text = getString(R.string.error_enter_password)
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvResult.text = getString(R.string.error_invalid_email)
                }

                password.length < 6 -> {
                    tvResult.text = getString(R.string.error_short_password)
                }

                else -> {
                    tvResult.text = getString(R.string.auth_success)
                    val intent = Intent(this, ProfileActivity::class.java).apply {
                        putExtra("EMAIL", email)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}
