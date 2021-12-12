package com.example.qrfamily.file

import okio.FileSystem
import java.io.File
import java.io.FileOutputStream

actual object FileSystem {

    internal actual val temporaryPath = FileSystem.SYSTEM_TEMPORARY_DIRECTORY.toString() + "/"

    actual fun readFile(fileName: String): Any? {
        val file = File(temporaryPath + fileName).canonicalFile ?: return null
        return file.readBytes()
    }

    actual fun writeFile(fileName: String, content: Any): Boolean {
        val file = File(temporaryPath + fileName).canonicalFile
        if (!file.exists()) {
            file.createNewFile()
        }

        FileOutputStream(file, false).write(content as ByteArray)
        return true
    }
}