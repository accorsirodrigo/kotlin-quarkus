package dev.rodrigoaccorsi.domain

import javax.inject.Singleton


@Singleton
class PushUseCaseImpl : MessageUseCase<PushMessage> {

    override fun send(message: PushMessage) {
        println("Enviando PUSH")
    }

    override fun process(message: PushMessage) = run {
        message
    }
}