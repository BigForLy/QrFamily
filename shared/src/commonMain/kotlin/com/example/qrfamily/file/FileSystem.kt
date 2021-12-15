package com.example.qrfamily.file

expect object FileSystem {
    internal val temporaryPath: String
    fun toByteArray(content: Any) : ByteArray?
    fun toImage(content: ByteArray): Any?
}