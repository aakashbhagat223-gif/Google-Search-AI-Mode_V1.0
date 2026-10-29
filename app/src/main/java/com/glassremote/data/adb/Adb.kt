package com.glassremote.data.adb

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket

class Adb(private val host: String, private val port: Int = 5555) {

    private var socket: Socket? = null
    private var outputStream: OutputStream? = null
    private var inputStream: InputStream? = null

    suspend fun connect(): Boolean = withContext(Dispatchers.IO) {
        try {
            socket = Socket(host, port).apply {
                soTimeout = 5000
                tcpNoDelay = true
            }
            outputStream = socket?.getOutputStream()
            inputStream = socket?.getInputStream()
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun execute(command: String): String = withContext(Dispatchers.IO) {
        try {
            outputStream?.write("$command\n".toByteArray(Charsets.UTF_8))
            outputStream?.flush()
            val buffer = ByteArray(1024)
            val bytesRead = inputStream?.read(buffer) ?: -1
            if (bytesRead > 0) String(buffer, 0, bytesRead, Charsets.UTF_8) else ""
        } catch (e: Exception) {
            ""
        }
    }

    suspend fun sendKey(keyCode: Int) {
        execute("input keyevent $keyCode")
    }

    fun disconnect() {
        try {
            socket?.close()
        } catch (_: Exception) {}
    }
}
