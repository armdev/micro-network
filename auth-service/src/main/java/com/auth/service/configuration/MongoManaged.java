package com.auth.service.configuration;

import com.google.inject.Inject;
import com.mongodb.Mongo;

import io.dropwizard.lifecycle.Managed;

public class MongoManaged implements Managed {

    private final Mongo mongo;
   
    @Inject
    public MongoManaged(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }

}
