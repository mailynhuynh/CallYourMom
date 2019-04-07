package com.example.restclienttest;

/**
 * Created by mailyns on 01/23/2019
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    @JsonProperty("baseExperience")
    private int baseExperience;
    @JsonProperty("height")
    private int height;
    @JsonProperty("weight")
    private int weight;

    public int getBaseExperience() {
        return baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
