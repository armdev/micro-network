package com.project.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import com.project.dropwizard.resources.MessageResource;

public class MainApplication extends Application<MainConfiguration> {

    //  private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);
    public static void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MainConfiguration> bootstrap) {

        bootstrap.addBundle(new SwaggerBundle<MainConfiguration>() {
            @Override
            public SwaggerBundleConfiguration getSwaggerBundleConfiguration(MainConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });

    }

    @Override
    public String getName() {
        return "mining-node";
    }

    @Override
    public void run(MainConfiguration configuration, Environment environment) throws Exception {

        environment.jersey().register(new MessageResource());

    }
}
