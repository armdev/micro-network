package com.project.micro.gateway.resources;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.google.inject.Inject;
import com.project.micro.gateway.client.AuthServiceClient;

import io.dropwizard.jersey.caching.CacheControl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/g1/auth")
@Api("/g1/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthServiceResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceResource.class);

    @Inject
    private AuthServiceClient authServiceClient;

    @GET
    @Path("/find/all")
    @Timed(name = "showAll-timed-get")
    @Metered(name = "showAll-metered-get")
    @ExceptionMetered
    @CacheControl(maxAge = 12, maxAgeUnit = TimeUnit.SECONDS)
    @JacksonFeatures(serializationEnable = {SerializationFeature.INDENT_OUTPUT})
    @ApiOperation("Save user")
    public List<Object> findAllUsers() throws Exception {
        LOGGER.info("Fetching all the users  ");
        JSONArray productCatalogs = authServiceClient.getAllUsers();
        if (productCatalogs == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return productCatalogs.toList();
    }

}
