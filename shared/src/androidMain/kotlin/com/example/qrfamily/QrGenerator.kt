package com.example.qrfamily

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter


class QrGenerator {

    fun getQrCodeBitmap(ssid: String, password: String): Bitmap {
        // https://stackoverflow.com/questions/64443791/android-qr-generator-api
        val size = 512 //pixels
        val qrCodeContent = "https://ktor.io/docs/getting-started-ktor-client.html"
//        val qrCodeContent = "WIFI:S:$ssid;T:WPA;P:$password;;"
//        val hints = hashMapOf<EncodeHintType, Int>().also { it[EncodeHintType.MARGIN] = 1 } // Make the QR code buffer border narrower
        val bits = QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE, size, size)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }
}