package com.vanlang.kiemtra_laptrinhungdungdidong_2474802010085

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        // Nhận Email từ LoginActivity
        val email = intent.getStringExtra("EMAIL")
        val noDataText = getString(R.string.no_data)
        tvEmail.text = getString(R.string.email_format, email ?: noDataText)

        btnLogout.setOnClickListener {
            finish()
        }

        // 3.3. Khởi tạo mảng gồm ít nhất 05 môn học/kỹ năng mẫu
        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // 3.4. Gắn ArrayAdapter với layout mẫu android.R.layout.simple_list_item_1
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // 3.5. Bắt sự kiện Click: Hiển thị Toast thông báo tên phần tử được chọn
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            val selectedSubject = subjects[position]
            Toast.makeText(this, "Đã chọn: $selectedSubject", Toast.LENGTH_SHORT).show()
        }
    }
}
