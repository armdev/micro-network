package io.project.application;


import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(name = "full-node", url = "${full.node.url}")
public interface GreetingClient extends GreetingController {
}
