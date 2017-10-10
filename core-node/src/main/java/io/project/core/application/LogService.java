package io.project.core.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;


@Service
public class LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);

    @Autowired
    private Tracer tracer;       

    public void log(String msg) {        
        Span logServiceSpan = this.tracer.createSpan("core-node-log");
        try {
            LOGGER.info(msg);
        } finally {
            this.tracer.close(logServiceSpan);
        }
    }

}