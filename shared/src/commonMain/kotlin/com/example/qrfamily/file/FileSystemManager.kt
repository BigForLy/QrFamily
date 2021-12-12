package com.example.qrfamily.file

import com.example.qrfamily.file.FileSystem

class FileSystemManager {

    fun readFile(fileName: String): Any? {
        return FileSystem.readFile(fileName)
    }

    fun writeFile(fileName: String, content: Any): Boolean {
        return FileSystem.writeFile(fileName, content)
    }
}