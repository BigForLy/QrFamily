package com.example.qrfamily

import kotlinx.cinterop.addressOf
import kotlinx.cinterop.readBytes
import kotlinx.cinterop.usePinned
import okio.FileSystem
import platform.Foundation.*

actual object FileSystem {

    internal actual val temporaryPath = FileSystem.SYSTEM_TEMPORARY_DIRECTORY.toString() + "/"

    actual fun readFile(fileName: String): Any? {

        val url = NSURL.fileURLWithPath(temporaryPath + fileName).standardizedURL
        val pathFromUrl = url?.standardizedURL?.path ?: return null
        return NSFileManager.defaultManager.contentsAtPath(pathFromUrl)
    }

    actual fun writeFile(fileName: String, content: Any): Boolean {
        val url = NSURL.fileURLWithPath(temporaryPath + fileName).standardizedURL
        val pathStandardized = url?.standardizedURL?.path ?: return false
        val data = content.toNSData() ?: return false
        return data.writeToFile(pathStandardized, true)
    }
}

private fun Any.toNSData(): NSData? {
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
