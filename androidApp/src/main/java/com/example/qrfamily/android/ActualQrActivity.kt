package com.example.qrfamily.android

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.qrfamily.file.FileSystem

class ActualQrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actual_qr)

        uiEditor()
    }

    private fun byteArray(): ByteArray? {
        return intent.getByteArrayExtra("byteArray")
    }

    private fun uiEditor() {
        val qrBitmap = byteArray()?.let { FileSystem.toImage(it) }
        val imageView = findViewById<ImageView>(R.id.imageView)
        qrBitmap?.let {imageView.setImageBitmap(it as Bitmap?)}
    }
}