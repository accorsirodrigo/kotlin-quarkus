package dev.rodrigoaccorsi.domain

data class SMSMessage(
    val driverUUID: String,
    val title: String,
    val message: String
)
