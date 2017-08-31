package com.auth.service.api;

import com.auth.service.models.MessageModel;
import com.auth.service.models.PongResponse;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface MessageAPI {

    @GET
    @Path("/v1/users/health")
    MessageModel getSecretMessage();

    @GET
    @Timed
    //@Path("pong")//failback will called
    @Path("/v1/users/doping")//sould be ok!
    @Produces(MediaType.APPLICATION_JSON)
    public PongResponse pong();

}
