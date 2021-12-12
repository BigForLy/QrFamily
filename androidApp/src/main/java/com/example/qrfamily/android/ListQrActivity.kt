package com.example.qrfamily.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import com.example.qrfamily.file.QrGenerator
import com.example.qrfamily.QRIntoFile
import com.example.qrfamily.android.adapter.QrCardAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListQrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_qr)

        val qr = QrGenerator().getQrCodeBitmap("asdaqqb")  // тестовое
        QRIntoFile().save(bmp =  qr, fileName = "test.png")
        uiEditor()
    }

    private fun uiEditor() {
        val listView = findViewById<ListView>(R.id.listView)
        val cat: Array<String> = arrayOf(
            "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
            "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
            "Китти", "Масяня", "Симба", "Томасина", "Кристина", "Пушок", "Дымка", "Кузя"
        )
        val adapter = QrCardAdapter(this, cat)
        listView.adapter = adapter

        listView.onItemClickListener =
            OnItemClickListener { parent, itemClicked, position, id ->
                println(
                    (itemClicked.findViewById(R.id.title_card) as TextView).text.toString()
                )
            }

        val addNewButton = findViewById<FloatingActionButton>(R.id.add_new_item)
        addNewButton.setOnClickListener {
            startActivity(Intent(this, AddingActivity::class.java))
        }
    }
}