package com.example.japanese

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startHiragana: Button = findViewById(R.id.startHiragana)
        val startKatakana: Button = findViewById(R.id.startKatakana)
        startHiragana.setOnClickListener {
            val intent = Intent(this, HiraganaTrainingActivity::class.java)
            startActivity(intent)
        }
        startKatakana.setOnClickListener {
            val intent = Intent(this, KatakanaTrainingActivity::class.java)
            startActivity(intent)
        }
    }
}