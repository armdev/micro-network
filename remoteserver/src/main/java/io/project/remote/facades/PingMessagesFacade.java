package io.project.remote.facades;

import io.project.remote.interfaces.ExternalAccess;

/**
 *
 * @author armen
 */
public class PingMessagesFacade implements ExternalAccess{

    @Override
    public String receiveMessages(String message) {
       return "Message " + message + " received and saved";
    }
    
}
