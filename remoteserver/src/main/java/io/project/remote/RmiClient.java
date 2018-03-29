package io.project.remote;

import io.project.remote.interfaces.ExternalAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication//should be another application
public class RmiClient {

    @Bean
    RmiProxyFactoryBean service() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1099/ExternalAccess");
        rmiProxyFactory.setServiceInterface(ExternalAccess.class);
        return rmiProxyFactory;
    }

    public static void main(String[] args) {
        ExternalAccess service = SpringApplication.run(RmiClient.class, args).getBean(ExternalAccess.class);
        String outcome = service.receiveMessages("13 Seagate Blvd, Key Largo, FL 33037");
        System.out.println(outcome);
    }

}
