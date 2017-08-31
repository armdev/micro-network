package com.project.dropwizard.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/v1/messages")
@Api("/v1/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {  

   
    public MessageResource() {   

    }

    @GET
    //@Path("/{id}")
    @ApiOperation("Find message by id")
    public Response get(@PathParam("id") long id) {
     //   Optional<Message> message = messageDAOProvider.getById(id);
        return Response.ok("I am a live").build();
    }

   
}
