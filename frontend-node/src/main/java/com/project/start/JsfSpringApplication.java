package com.project.start;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EnableAutoConfiguration
public class JsfSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsfSpringApplication.class, args);
    }

    @Bean
    public HazelcastInstance hazelcastInstance() {
        //adding ttl for list, may be will help:)))))
        Config config = new Config();
        LocalListConfig listConfig = new LocalListConfig();
        listConfig.setMaxSize(5000);
        listConfig.setTimeToLiveSeconds(100);
      //  listConfig.setBackupCount(4);
        listConfig.setName("flightList");
        config.addListConfig(listConfig);
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        return instance;
    }
}
