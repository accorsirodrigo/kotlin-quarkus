package dev.rodrigoaccorsi.http

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class ReactiveGreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello RESTEasy Reactive in Kotlin"

    @GET
    @Path("/new")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello2() = "This is a new Request!"
}