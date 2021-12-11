package com.example.qrfamily

import okio.FileSystem

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    fun temporaryDirectory(): String {
        return FileSystem.SYSTEM_TEMPORARY_DIRECTORY.toString()
    }
}