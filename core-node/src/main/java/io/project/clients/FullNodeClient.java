package io.project.clients;


import io.project.controllers.ClientController;
import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(name = "full-node", url = "${full.node.url}")
public interface FullNodeClient extends ClientController {
}
