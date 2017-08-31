package com.project.dropwizard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Message {

    @JsonProperty("id")
    @JsonIgnore
    private long id;

    @JsonProperty("message")
    @JsonIgnore
    private String message;

    @JsonProperty("status")
    @JsonIgnore
    private boolean status;

    public Message(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

}
