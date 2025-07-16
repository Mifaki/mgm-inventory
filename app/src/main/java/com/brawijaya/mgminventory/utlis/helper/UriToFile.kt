package com.brawijaya.mgminventory.utlis.helper

import android.content.Context
import android.net.Uri
import java.io.File

fun uriToFile(context: Context, uri: Uri): File? {
    return try {
        val inputStream = context.contentResolver.openInputStream(uri) ?: return null
        val file = File.createTempFile("ktm_", ".jpg", context.cacheDir)
        file.outputStream().use { output ->
            inputStream.copyTo(output)
        }
        file
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
