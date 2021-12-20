package com.example.qrfamily.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.qrfamily.Greeting
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uiEditor()
    }

    private fun uiEditor() {
        val tv: TextView = findViewById(R.id.text_view)
        tv.text = Greeting().greeting()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this, ListQrActivity::class.java))
        }
    }
}
