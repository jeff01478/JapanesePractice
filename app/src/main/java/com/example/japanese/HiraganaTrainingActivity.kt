package com.example.japanese

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HiraganaTrainingActivity : AppCompatActivity() {

    lateinit var word: TextView
    lateinit var answer: EditText
    lateinit var submit: Button

    private val hiraganaMap: HashMap<String, String> = JanpenesWord.hiraganaMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hiragana_training)
        initObject()
        var good = hiraganaMap.keys.random()
        word.text = good
        submit.setOnClickListener {
            if (answer.text.toString() != hiraganaMap[good])
                Toast.makeText(this, "Answer failed", Toast.LENGTH_SHORT).show()
            else {
                hiraganaMap.remove(good)
                if (hiraganaMap.size == 0) {
                    Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
                    finish()
                }
                good = hiraganaMap.keys.random()
                word.text = good
                answer.setText("")
                Log.d("GOOD", hiraganaMap.size.toString())
            }
        }
    }

    private fun initObject() {
        word = findViewById(R.id.word)
        answer = findViewById(R.id.answer)
        submit = findViewById(R.id.submit)
    }
}