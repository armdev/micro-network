package com.project.micro.gateway;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.project.micro.gateway.health.AServiceHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.discovery.DiscoveryBundle;
import io.dropwizard.discovery.DiscoveryFactory;
import io.dropwizard.discovery.client.DiscoveryClient;
import io.dropwizard.discovery.client.DiscoveryClientManager;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.whispersystems.dropwizard.simpleauth.AuthValueFactoryProvider;

public class MicroGatewayApplication extends Application<MicroGatewayConfiguration> {
    
     // http://localhost:8080/api/swagger

    public static void main(final String[] args) throws Exception {
        new MicroGatewayApplication().run(args);
    }

    private GuiceBundle<MicroGatewayConfiguration> guiceBundle;

    private final DiscoveryBundle<MicroGatewayConfiguration> discoveryBundle = new DiscoveryBundle<MicroGatewayConfiguration>() {

        @Override
        public DiscoveryFactory getDiscoveryFactory(MicroGatewayConfiguration configuration) {
            return configuration.getDiscoveryFactory();
        }
    };

    @Override
    public String getName() {
        return "api-gateway";
    }

    @Override
    public void initialize(final Bootstrap<MicroGatewayConfiguration> bootstrap) {
     
        bootstrap.addBundle(discoveryBundle);
        guiceBundle = GuiceBundle.<MicroGatewayConfiguration>newBuilder().addModule(new JerseyModule())
                .enableAutoConfig(getClass().getPackage().getName()).setConfigClass(MicroGatewayConfiguration.class)
                .build(Stage.PRODUCTION);
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new SwaggerBundle<MicroGatewayConfiguration>() {
            @Override
            public SwaggerBundleConfiguration getSwaggerBundleConfiguration(MicroGatewayConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });

    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void run(final MicroGatewayConfiguration configuration, final Environment environment) throws Exception {

        final DiscoveryClient authServiceClient = discoveryBundle.newDiscoveryClient("auth-service");
        DiscoveryClientManager authServiceManager = new DiscoveryClientManager(authServiceClient);
        environment.lifecycle().manage(authServiceManager);
        
        configuration.setAuthServiceDiscoveryClient(authServiceClient);

        // register health checks
        environment.healthChecks().register("auth service",
                guiceBundle.getInjector().getInstance(AServiceHealthCheck.class));

        environment.jersey().register(new AuthValueFactoryProvider.Binder());

    }

}
