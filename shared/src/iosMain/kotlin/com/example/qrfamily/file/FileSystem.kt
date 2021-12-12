package com.example.qrfamily.file

import okio.FileSystem
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.writeToFile

actual object FileSystem {

    internal actual val temporaryPath = FileSystem.SYSTEM_TEMPORARY_DIRECTORY.toString() + "/"

    actual fun readFile(fileName: String): Any? {

        val url = NSURL.fileURLWithPath(temporaryPath + fileName).standardizedURL
        val pathFromUrl = url?.standardizedURL?.path ?: return null
        return NSFileManager.defaultManager.contentsAtPath(pathFromUrl)
    }

    actual fun writeFile(fileName: String, content: Any): Boolean {
        val url = NSURL.fileURLWithPath(temporaryPath + fileName).standardizedURL
        val pathStandardized = url?.standardizedURL?.path ?: return false
        val data = content.toNSData() ?: return false
        return data.writeToFile(pathStandardized, true)
    }
}