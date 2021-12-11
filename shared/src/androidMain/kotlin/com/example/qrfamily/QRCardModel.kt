package com.example.qrfamily

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import android.graphics.BitmapFactory
import java.lang.Exception

class SavedManager {
    fun readBitmap(path: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val options = BitmapFactory.Options()
            options.inPreferredConfig = Bitmap.Config.ARGB_8888
//            bitmap = BitmapFactory.decodeStream(FileInputStream(path), null, options)
            val z = FileSystemManager().readFile( "test.png") as ByteArray
            bitmap = BitmapFactory.decodeByteArray(z, 0, z.size, options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    fun saveBitmap(bmp: Bitmap, path: String) {
        val bytes = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.JPEG, 60, bytes)
        try {
            val f = File(path)
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            fo.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}