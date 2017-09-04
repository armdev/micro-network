package io.project.core.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import io.project.core.application.HealthChecker;

/**
 *
 * @author armdev
 */
@FeignClient(name = "full-node", url = "${full.node.url}")
public interface FullNodeClient extends HealthChecker {
}
