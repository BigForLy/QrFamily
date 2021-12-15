package com.example.qrfamily.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.qrfamily.data.DatabaseManager
import com.example.qrfamily.file.FileSystem
import com.example.qrfamily.file.QrGenerator

class AddingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding)

        uiEditor()
    }

    private fun uiEditor() {
        val addButton = findViewById<Button>(R.id.button2)
        val name = findViewById<EditText>(R.id.editTextName)
        val url = findViewById<EditText>(R.id.editTextLink)
        addButton.setOnClickListener {
            val qrBitmap = QrGenerator().getQrCodeBitmap(url.text.toString())
            val byteArray = FileSystem.toByteArray(qrBitmap)
            byteArray?.let { array ->
                DatabaseManager().insertCard(
                    name = name.text.toString(),
                    qr = array
                )
            }
            val intent = Intent(this, ActualQrActivity::class.java).apply {
                putExtra("byteArray", byteArray)
            }
            startActivity(intent)
            finish()
        }
    }
}