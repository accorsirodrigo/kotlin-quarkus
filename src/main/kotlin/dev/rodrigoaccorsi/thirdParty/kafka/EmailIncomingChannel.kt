package dev.rodrigoaccorsi.thirdParty.kafka

import dev.rodrigoaccorsi.cdi.SomeModel
import java.util.concurrent.CompletionStage
import javax.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Message
import org.jboss.logging.Logger

@ApplicationScoped
class EmailIncomingChannel(
    private val model: SomeModel
) {
    private val logger = Logger.getLogger(EmailIncomingChannel::class.java)

    @Incoming("email-channel")
    fun consume(message: String){
        logger.infof(model.messageFormatter(message))
    }
}