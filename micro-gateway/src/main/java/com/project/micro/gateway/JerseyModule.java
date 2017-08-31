package com.project.micro.gateway;

import javax.ws.rs.client.Client;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

public class JerseyModule extends AbstractModule {

    private Client jerseyClient;

    @Provides
    public Client getJerseyClient(Environment environment, MicroGatewayConfiguration configuration) {
        if (jerseyClient == null) {
            jerseyClient = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                    .build(environment.getName());
        }
        return jerseyClient;
    }

    @Override
    protected void configure() {

    }

}
