package dev.rodrigoaccorsi.domain

import javax.inject.Singleton


@Singleton
class SMSUseCaseImpl : MessageUseCase<SMSMessage> {

    override fun send(message: SMSMessage) {
        println("Enviando")
    }

    override fun process(message: SMSMessage) = run {
        message
    }
}