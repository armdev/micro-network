package io.project.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableAsync
@EnableFeignClients
@EnableMongoAuditing
@EnableMongoRepositories
@EnableScheduling
@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
@Import(SpringConfig.class)
@ComponentScan(basePackages = {"io"}, excludeFilters = {
@ComponentScan.Filter(Configuration.class)})
public class FullNodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullNodeApplication.class, args);
    }

}
