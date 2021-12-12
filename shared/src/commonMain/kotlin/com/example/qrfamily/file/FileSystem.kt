package com.example.qrfamily.file

expect object FileSystem {
    internal val temporaryPath: String
    fun readFile(fileName: String): Any?
    fun writeFile(fileName: String, content: Any): Boolean
}