package com.example.qrfamily.data

import com.example.qrfamily.db.QRBase
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual object DatabaseFactory {
    private val driver = NativeSqliteDriver(QRBase.Schema, "tCards.db")
    actual val db : QRBase = QRBase(driver)
}