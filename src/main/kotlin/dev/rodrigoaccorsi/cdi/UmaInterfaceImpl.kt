package dev.rodrigoaccorsi.cdi

import io.quarkus.arc.Priority
import javax.enterprise.inject.Alternative
import javax.inject.Singleton

@Singleton
@Alternative
@Priority(999)
class UmaInterfaceImpl: UmaInterface {
    override fun escreve() {
        println("Oi, escrevi")
    }
}