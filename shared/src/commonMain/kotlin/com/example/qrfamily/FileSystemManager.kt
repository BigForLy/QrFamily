package com.example.qrfamily

class FileSystemManager {

    fun readFile(fileName: String): Any? {
        return FileSystem.readFile(fileName)
    }

    fun writeFile(fileName: String, content: Any): Boolean {
        return FileSystem.writeFile(fileName, content)
    }
}