package com.jdkd.academy.world;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Academy {

    @JsonProperty
    private String name;

    public Academy(String name) {
        this.name = name;
    }

    public Academy() {
    }

    public String getName() {
        return name;
    }
}
