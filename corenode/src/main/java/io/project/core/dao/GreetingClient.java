package io.project.core.dao;
import org.springframework.cloud.netflix.feign.FeignClient;

//@FeignClient(name="fullnode", url = "${full.node.url}")
public interface GreetingClient extends GreetingController {
}
