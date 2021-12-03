package com.example.qrfamily

//import io.ktor.client.*
//import io.ktor.client.features.*
//import io.ktor.client.request.*

class Greeting {
    fun greeting(): String {
//        val client = HttpClient()
//        val response = client.get<String>("https://ktor.io/")
        return "Hello, ${Platform().platform}!"
    }
}