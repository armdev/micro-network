package io.project.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import io.project.controllers.HealthCheckController;


@FeignClient(name = "full-node", url = "${full.node.url}")
public interface FullNodeClient extends HealthCheckController {
}
