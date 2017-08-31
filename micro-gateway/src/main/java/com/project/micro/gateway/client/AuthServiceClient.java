package com.project.micro.gateway.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.curator.x.discovery.ServiceInstance;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.project.micro.gateway.MicroGatewayConfiguration;
import java.util.logging.Level;
import org.json.JSONException;

public class AuthServiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceClient.class);

    private final static String SERVICE_PATH = "/auth/v1/users/all";

    private final static String HEALTH_CHECK_PATH = "/api/product/catalog/health";

    @Inject
    private Client client;

    @Inject
    private MicroGatewayConfiguration configuration;

    public JSONArray getAllUsers() {
        try {
            ServiceInstance instance = this.configuration.getAuthServiceDiscoveryClient().getInstance();
            String address = instance.getAddress();
            Integer port = instance.getPort();

            String endpoint = "http://" + address + ":" + port + SERVICE_PATH;
            LOGGER.info("address " + address);
            LOGGER.info("instance.getName(); " + instance.getName());
            LOGGER.info("FULL PATH: " + endpoint);
            Response response = client.target(endpoint).request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON).get();

            String responseString = response.readEntity(String.class);

            LOGGER.info("responseString:@#$  " + responseString);
            if (response.getStatus() == 404) {
                return null;
            }
            JSONArray obj = new JSONArray(responseString);
            return obj;
        } catch (JSONException e) {
            LOGGER.error(e.getMessage());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AuthServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new JSONArray();
    }

    public boolean isClientHealthy() {
        try {
            ServiceInstance instance = this.configuration.getAuthServiceDiscoveryClient().getInstance();
            String address = instance.getAddress();
            Integer port = instance.getPort();
            String endpoint = "http://" + address + ":" + port + HEALTH_CHECK_PATH;
            Response response = client.target(endpoint).request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON).get();
            return response.getStatus() == 200;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return false;
    }

}
