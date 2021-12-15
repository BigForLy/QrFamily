package com.example.qrfamily.data

import comexampleqrfamilydb.TCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DatabaseManager {
    private val db = DatabaseFactory.db

    fun insertCard(name: String, qr: ByteArray) {
        GlobalScope.launch(Dispatchers.Unconfined) {
            db.cardEntityQueries.insertCard(name = name, qr = qr)
        }
    }

    fun getAllCard() : List<TCard> {
        return db.cardEntityQueries.selectAll().executeAsList()
    }
}