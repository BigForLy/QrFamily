package com.example.qrfamily.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.qrfamily.QrGenerator

class ListQrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_qr)

        uiEditor()
    }

    private fun uiEditor() {
        val z = QrGenerator().getQrCodeBitmap("qwe", "qwer")
        val image = findViewById<ImageView>(R.id.imageView)
        image.setImageBitmap(z)
    }
}