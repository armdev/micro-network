package com.project.dropwizard.integration;

import com.project.dropwizard.MainApplication;
import com.project.dropwizard.MainConfiguration;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.util.Duration;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

public class PortalMessageUtilTest {

    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("config.yml");

    @ClassRule
    public static final DropwizardAppRule<MainConfiguration> RULE = new DropwizardAppRule<>(
            MainApplication.class, CONFIG_PATH);

    private static Client client;
    private static WebTarget target;

    @BeforeClass
    public static void setUp() throws Exception {
        final JerseyClientConfiguration clientConfig = new JerseyClientConfiguration();
        clientConfig.setTimeout(Duration.seconds(30));
        client = new JerseyClientBuilder(RULE.getEnvironment())
                .using(clientConfig)
                .build("Test client");
        target = client.target(String.format("http://localhost:%d/v1/portal/message", RULE.getLocalPort()));
    }

    @Test
    public void testPutMessage() throws Exception {
        final String message = "Important message for Kazan portal!!!";
        Response output = target.request().put(Entity.entity(message, MediaType.TEXT_HTML));
        //System.out.println(" output.getStatus() " + output.getStatus());

        assertEquals("Should return status 200", 200, output.getStatus());

    }

    @Test
    public void testGetMessage() throws Exception {
        Response responseString = target
                .request().get(Response.class);

        System.out.println(" output.getStatus() " + responseString.toString());
        assertThat(responseString);

    }

    @Test
    public void testDeleteFile() throws Exception {
        Response output = target.request().delete();
        assertEquals("Should return status 200", 200, output.getStatus());

    }

    @AfterClass
    public static void testDown() throws Exception {
        client.close();
    }

}
