package com.example.qrfamily.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.qrfamily.Greeting
import android.widget.TextView

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uiEditor()
    }

    private fun uiEditor() {
        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ListQrActivity::class.java)
            startActivity(intent)
        }
    }
}
