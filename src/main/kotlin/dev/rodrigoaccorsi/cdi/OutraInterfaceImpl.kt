package dev.rodrigoaccorsi.cdi

import io.quarkus.arc.Priority
import javax.enterprise.inject.Alternative
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Alternative
@Priority(1)
@Named("outra")
class OutraInterfaceImpl : UmaInterface {


    override fun escreve() {
        println("Oi, escrevi outra")
    }
}