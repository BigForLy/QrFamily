package com.example.qrfamily.file

import kotlinx.cinterop.addressOf
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.usePinned
import platform.Foundation.*

fun Any.toNSData(): NSData? {
    return when (this) {
        is NSData -> this
        else -> {
            null
        }
    }
}

private fun NSData.toByteArray(): ByteArray? {
    if (bytes == null) {
        return null
    }
    return bytes!!.readBytes(length.toInt())
}

fun ByteArray.toNSData(): NSData? {
    if (isEmpty()) {
        return null
    }

    return usePinned {
        return@usePinned NSData.dataWithBytes(it.addressOf(0), it.get().size.toULong())
    }
}
