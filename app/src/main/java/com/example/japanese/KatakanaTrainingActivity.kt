package com.example.japanese

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class KatakanaTrainingActivity : AppCompatActivity() {
    lateinit var word: TextView
    lateinit var answer: EditText
    lateinit var submit: Button

    private val katakanaMap: HashMap<String, String> = JanpenesWord.katakanaMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katakana_training)
        initObject()
        var good = katakanaMap.keys.random()
        word.text = good
        submit.setOnClickListener {
            if (answer.text.toString() == katakanaMap[good])
                Toast.makeText(this, "Answer failed", Toast.LENGTH_SHORT).show()
            else {
                katakanaMap.remove(good)
                if (katakanaMap.size == 0) {
                    Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
                    finish()
                }
                good = katakanaMap.keys.random()
                word.text = good
                answer.setText("")
                Log.d("GOOD", katakanaMap.size.toString())
            }
        }
    }

    private fun initObject() {
        word = findViewById(R.id.word)
        answer = findViewById(R.id.answer)
        submit = findViewById(R.id.submit)
    }
}