package com.example.qrfamily.file

class FileSystemManager {

    fun readFile(fileName: String): Any? {
        return FileSystem.readFile(fileName)
    }

    fun writeFile(fileName: String, content: Any): Boolean {
        return FileSystem.writeFile(fileName, content)
    }
}