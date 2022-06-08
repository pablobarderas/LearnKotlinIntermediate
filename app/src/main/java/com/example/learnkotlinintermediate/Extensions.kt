package com.example.learnkotlinintermediate

import java.text.SimpleDateFormat
import java.util.*

// this function it has been added to class Date
fun Date?.customFormat() : String? {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sssZZZ", Locale.getDefault())
    if (this != null) {
        return formatter.format(this)
    }
    return null // If it's null
}

val Date?.formatSize : Int
    get() = this.customFormat()?.length ?: 0 // If it's null

