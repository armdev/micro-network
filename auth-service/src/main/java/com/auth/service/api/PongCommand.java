package com.auth.service.api;

import com.auth.service.handlers.FeignService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class PongCommand extends HystrixCommand<String> {

    public PongCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("PongCommand"));
    }

    @Override
    protected String run() throws Exception {
        FeignService feignService = new FeignService();
        MessageAPI msgs = feignService.getClient().target(MessageAPI.class, "http://localhost:9900/auth");
        return msgs.pong().getResponse();

    }

    @Override
    protected String getFallback() {
        return "fallback";
    }

}
