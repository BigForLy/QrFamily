package com.example.qrfamily.data

import com.example.qrfamily.db.QRBase

expect object DatabaseFactory {
    val db : QRBase
}