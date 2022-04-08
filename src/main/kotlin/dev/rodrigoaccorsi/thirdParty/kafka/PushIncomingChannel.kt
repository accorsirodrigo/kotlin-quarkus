package dev.rodrigoaccorsi.thirdParty.kafka

import dev.rodrigoaccorsi.cdi.SomeModel
import dev.rodrigoaccorsi.domain.MessageUseCase
import dev.rodrigoaccorsi.domain.PushMessage
import java.util.concurrent.CompletionStage
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Message
import org.jboss.logging.Logger

@ApplicationScoped
class PushIncomingChannel(
    private val model: SomeModel,
    private val pushUseCase: MessageUseCase<PushMessage>
) {
    private val logger = Logger.getLogger(PushIncomingChannel::class.java)

    @Incoming("push-channel")
    fun consume(message: Message<String>): CompletionStage<Void> {
        logger.infof(model.messageFormatter(message.payload))
        return message.ack()
    }
}