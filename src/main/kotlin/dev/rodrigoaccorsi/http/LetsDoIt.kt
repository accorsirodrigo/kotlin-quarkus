package dev.rodrigoaccorsi.http

import dev.rodrigoaccorsi.cdi.UmaInterface
import javax.inject.Named
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("ifood")
class LetsDoIt(

    val umaInterface: UmaInterface,

    @Named("outra")
    val outraInterface: UmaInterface
    ) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun youRock() = Rock(name = "Rodrigo")

    @GET
    @Path("/suspend/{surname}")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun youRockSuspended(@PathParam("surname") surname: String?) = Rock(name = "Rodrigo").rockYou(surname)

    @GET
    @Path("/suspend1")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun suspend() = umaInterface.escreve()

    @GET
    @Path("/suspend2")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun user() = outraInterface.escreve()

}