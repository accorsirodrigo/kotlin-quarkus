package dev.rodrigoaccorsi.domain


data class PushMessage(
    val driverUUID: String,
    val title: String,
    val message: String
)
