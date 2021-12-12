package com.example.qrfamily.data

import android.content.Context
import com.example.qrfamily.db.QRBase
import com.squareup.sqldelight.android.AndroidSqliteDriver

lateinit var appContext: Context

actual object DatabaseFactory {
    private val driver = AndroidSqliteDriver(QRBase.Schema, appContext, "tCards.db")
    actual val db : QRBase = QRBase(driver)
}