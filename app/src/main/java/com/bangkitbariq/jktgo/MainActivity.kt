package com.bangkitbariq.jktgo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkitbariq.jktgo.chatbot.ChatbotActivity
import com.bangkitbariq.jktgo.ProfileActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FloatingActionButton untuk Chatbot
        val fabChatbot: FloatingActionButton = findViewById(R.id.fab_chatbot)
        fabChatbot.setOnClickListener {
            val intent = Intent(this@MainActivity, ChatbotActivity::class.java)
            startActivity(intent)
        }

        // BottomNavigationView untuk navigasi
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.item_dashboard // Tandai item aktif

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_profile -> {
                    val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                    startActivity(intent)
                    finish() // Tutup MainActivity agar tidak ada banyak aktivitas
                    true
                }
                R.id.item_dashboard -> true // Tetap di halaman ini
                else -> false
            }
        }
    }
}
