package com.project.start;

import com.hazelcast.config.ListConfig;
import static com.hazelcast.config.MapConfig.DEFAULT_TTL_SECONDS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author armenar
 */
public class LocalListConfig extends ListConfig {
    
    private static final Logger log = LoggerFactory.getLogger(LocalListConfig.class);
    private int timeToLiveSeconds = DEFAULT_TTL_SECONDS;
    
    public LocalListConfig() {
    }
    
    public LocalListConfig(LocalListConfig config) {
        
        this.timeToLiveSeconds = config.getTimeToLiveSeconds();
    }
    
    public int getTimeToLiveSeconds() {
        log.info("time to live in seconds is " + timeToLiveSeconds);
        return timeToLiveSeconds;
    }
    
    public LocalListConfig setTimeToLiveSeconds(int timeToLiveSeconds) {
        this.timeToLiveSeconds = timeToLiveSeconds;
        return this;
    }
    
}
