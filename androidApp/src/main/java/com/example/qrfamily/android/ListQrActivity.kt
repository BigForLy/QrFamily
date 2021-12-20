package com.example.qrfamily.android

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.qrfamily.android.adapter.QrCardAdapter
import com.example.qrfamily.data.DatabaseManager
import com.example.qrfamily.data.appContext
import com.google.android.material.floatingactionbutton.FloatingActionButton
import comexampleqrfamilydb.TCard
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class ListQrActivity : AppCompatActivity() {
    private lateinit var allCard: List<TCard>
    private lateinit var adapter: QrCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_qr)

        uiEditor()
    }

    private fun uiEditor() {
        GlobalScope.launch(Dispatchers.IO) {
            appContext = applicationContext
            allCard = DatabaseManager().getAllCard()
            runOnUiThread {
                val listView = findViewById<ListView>(R.id.listView)
                adapter = QrCardAdapter(this@ListQrActivity, allCard)
                adapter.notifyDataSetChanged()
                listView.adapter = adapter
            }
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.onItemClickListener =
            OnItemClickListener { parent, itemClicked, position, id ->
                startActivity(Intent(this, ActualQrActivity::class.java).apply {
                    putExtra("byteArray", allCard[position].qr)
                })
            }

        val addNewButton = findViewById<FloatingActionButton>(R.id.add_new_item)
        addNewButton.setOnClickListener {
            startActivity(Intent(this, AddingActivity::class.java))
        }
    }

    private fun getDBData() {
        GlobalScope.launch(Dispatchers.IO) {
            if (this@ListQrActivity::adapter.isInitialized &&
            allCard.size != DatabaseManager().getCountCard()) {
                allCard = DatabaseManager().getAllCard()
                adapter.data = allCard
                runOnUiThread {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDBData()
    }
}