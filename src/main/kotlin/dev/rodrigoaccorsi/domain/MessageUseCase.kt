package dev.rodrigoaccorsi.domain

interface MessageUseCase<T> {

    fun send(message: T)
    fun process(message: T): T
}