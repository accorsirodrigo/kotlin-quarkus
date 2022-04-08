package dev.rodrigoaccorsi.thirdParty.kafka

import dev.rodrigoaccorsi.cdi.SomeModel
import dev.rodrigoaccorsi.domain.MessageUseCase
import dev.rodrigoaccorsi.domain.PushMessage
import dev.rodrigoaccorsi.domain.SMSMessage
import java.util.concurrent.CompletionStage
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Message
import org.jboss.logging.Logger

@ApplicationScoped
class SMSIncomingChannel(
    private val model: SomeModel,
    private val smsSender: MessageUseCase<SMSMessage>,
    @Channel("push-channel-out")
    private val emitter: Emitter<PushMessage>
) {
    private val logger = Logger.getLogger(SMSIncomingChannel::class.java)

    @Incoming("sms-channel")
    fun consume(message: Message<String>): CompletionStage<Void> {
        try {
            val payload = message.payload

//            smsSender.send(payload)

            logger.infof(model.messageFormatter(payload.toString()))

            throw IllegalArgumentException("Deu ruim")

//            emitter.send(
//                PushMessage(
//                    payload.driverUUID.toString(),
//                    payload.title,
//                    payload.message
//                )
//            )

            return message.ack()
        } catch (e: Exception) {
            return message.nack(e)
        }

    }
}