package com.auth.service.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.discovery.DiscoveryFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
public class MainConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String mongohost;

    @JsonProperty
    private final int mongoport = 27017;

    @JsonProperty
    private int timeout;

    @JsonProperty
    @NotEmpty
    private final String mongodb = "userDB";

    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    @JsonProperty
    private Map<String, Object> defaultHystrixConfig;

    @Valid
    @NotNull
    private DiscoveryFactory discovery = new DiscoveryFactory();

    @JsonProperty("discovery")
    public DiscoveryFactory getDiscoveryFactory() {
        return discovery;
    }

    @JsonProperty("discovery")
    public void setDiscoveryFactory(DiscoveryFactory discoveryFactory) {
        this.discovery = discoveryFactory;
    }

}
