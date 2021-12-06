package com.example.qrfamily.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView

class ListQrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_qr)

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
    }
}