package com.project.micro.gateway.health;

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;
import com.project.micro.gateway.client.AuthServiceClient;

/**
 *
 * @author Admin
 */
public class AServiceHealthCheck extends HealthCheck {

    @Inject
    private AuthServiceClient client;

    /*
	 * (non-Javadoc)
	 * 
	 * @see com.codahale.metrics.health.HealthCheck#check()
     */
    @Override
    protected HealthCheck.Result check() throws Exception {
        if (client.isClientHealthy()) {
            return HealthCheck.Result.healthy();
        }
        return HealthCheck.Result.unhealthy("Auth Service client is unhealthy!");
    }

}
