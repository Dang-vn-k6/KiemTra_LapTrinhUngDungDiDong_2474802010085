package com.vanlang.kiemtra_laptrinhungdungdidong_2474802010085

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Nhận Email từ LoginActivity
        val email = intent.getStringExtra("EMAIL")
        val noDataText = getString(R.string.no_data)
        tvEmail.text = getString(R.string.email_format, email ?: noDataText)

        btnLogout.setOnClickListener {
            finish()
        }
    }
}
