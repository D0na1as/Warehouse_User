package com.warehouse.user.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Log {

    @JsonProperty("From")
    private String origin;
    @JsonProperty("To")
    private String destination;
    @JsonProperty("Time")
    private String time;
    public Log() {
    }

    public Log(String origin, String destination, String time) {
        this.origin = origin;
        this.destination = destination;
        this.time = time;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
