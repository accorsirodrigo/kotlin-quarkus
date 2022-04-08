package dev.rodrigoaccorsi.http

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

data class Rock(
    val name: String,
    val surname: String? = null
) {

    suspend fun rockYou(surname: String?) = withContext(Dispatchers.IO) {
        delay(2000)
        return@withContext this@Rock.copy(surname = surname)
    }
}