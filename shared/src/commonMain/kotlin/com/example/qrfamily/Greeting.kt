package com.example.qrfamily

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}