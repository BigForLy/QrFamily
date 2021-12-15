package com.example.qrfamily.file

class FileSystemManager {

    fun toByteArray(content: Any) : ByteArray? {
        return FileSystem.toByteArray(content)
    }

    fun toImage(content: ByteArray): Any? {
        return FileSystem.toImage(content)
    }
}