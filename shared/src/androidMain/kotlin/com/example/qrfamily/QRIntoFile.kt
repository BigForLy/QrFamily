package com.example.qrfamily

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import android.graphics.BitmapFactory
import com.example.qrfamily.file.FileSystemManager
import java.lang.Exception

class QRIntoFile {

    fun read(fileName: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val options = BitmapFactory.Options()
            options.inPreferredConfig = Bitmap.Config.ARGB_8888
            val byteArray = FileSystemManager().readFile(fileName = fileName) as ByteArray
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size, options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    fun save(bmp: Bitmap, fileName: String) {
        val bytes = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.JPEG, 60, bytes)
        try {
            FileSystemManager().writeFile(fileName = fileName, content = bytes.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}