package dev.rodrigoaccorsi.cdi

import javax.enterprise.inject.Model

@Model
class SomeModel {
    fun messageFormatter(message: String) = "Got a formated: $message"
}