package com.example.qrfamily.data

import comexampleqrfamilydb.TCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatabaseManager {
    private val db = DatabaseFactory.db

    suspend fun insertCard(name: String, qr: ByteArray) : Boolean {
        return withContext(Dispatchers.Default) {
            db.cardEntityQueries.insertCard(name = name, qr = qr)
            true
        }
    }

    suspend fun getAllCard() : List<TCard> {
        return withContext(Dispatchers.Default) {
            db.cardEntityQueries.selectAll().executeAsList()
        }
    }

    suspend fun getCountCard() : Int {
        return withContext(Dispatchers.Default) {
            db.cardEntityQueries.selectCountCard().executeAsOne().toInt()
        }
    }
}