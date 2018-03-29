package io.project.remote;

import io.project.remote.facades.PingMessagesFacade;
import io.project.remote.interfaces.ExternalAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

@SpringBootApplication
public class RemoteServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteServerApplication.class, args);
    }

    @Bean
    public ExternalAccess pingService() {
        return new PingMessagesFacade();
    }

    @Bean
    public RmiServiceExporter exporter(ExternalAccess implementation) {
        Class<ExternalAccess> serviceInterface = ExternalAccess.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(serviceInterface);
        exporter.setService(implementation);
        exporter.setServiceName(serviceInterface.getSimpleName());
        exporter.setRegistryPort(1099);
        return exporter;
    }
}
