package com.example.qrfamily.file

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import okio.FileSystem
import java.io.ByteArrayOutputStream

actual object FileSystem {

    internal actual val temporaryPath = FileSystem.SYSTEM_TEMPORARY_DIRECTORY.toString() + "/"

    actual fun toByteArray(content: Any) : ByteArray? {
        return when (content) {
            is Bitmap -> {
                val bytes = ByteArrayOutputStream()
                content.compress(Bitmap.CompressFormat.JPEG, 60, bytes)
                bytes.toByteArray()
            }
            else -> { null }
        }
    }

    actual fun toImage(content: ByteArray): Any? {
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        return BitmapFactory.decodeByteArray(content, 0, content.size, options) as Bitmap
    }
}