package com.propify.challenge.properties.model;

public enum Type {

    SINGLE_FAMILY("Single Family"),
    MULTI_FAMILY2("Multi-family"),
    CONDOMINIUM("Condominium"),
    TOWNHOUSE("Townhouse");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
