package com.auth.service.resources;

import com.auth.service.api.MessageAPI;
import com.auth.service.api.PongCommand;
import com.auth.service.handlers.FeignService;
import com.auth.service.models.MessageModel;
import com.auth.service.models.PongResponse;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.jetty.http.HttpStatus;

/**
 *
 * @author armdev
 */
@Path("/v1/feign")
@Api("/v1/feign")
@Produces(MediaType.APPLICATION_JSON)
public class FeignResource {

    private final MessageAPI sendMessageAPI;
    private final FeignService feignService;

    public FeignResource(FeignService feignService) {
        //call some another REST service
        sendMessageAPI = feignService.getClient().target(MessageAPI.class, "http://localhost:9900/auth");
        this.feignService = feignService;
    }

    @Timed
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MessageModel secretMessage() {
        MessageModel message = sendMessageAPI.getSecretMessage();
        return message;
    }

    @GET
    @Path("/ping")
    @ApiOperation("Return PONG")
    @Consumes(MediaType.TEXT_PLAIN + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String ping() {
        return "PONG!!!!";
    }

    @GET
    @Path("/doping")
    @ApiOperation("Do Ping")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Response doPing() {
        return Response.status(HttpStatus.OK_200).entity(new PongResponse("Do pingvin " + pong())).build();
    }

    private String pong() {
        return new PongCommand().execute();
    }
}
