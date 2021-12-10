package com.example.qrfamily.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.qrfamily.QrGenerator

class ActualQrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actual_qr)

        uiEditor()
    }

    private fun uiEditor() {
        val qrBitmap = QrGenerator().getQrCodeBitmap("qwe", "qwer")
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageBitmap(qrBitmap)
    }
}