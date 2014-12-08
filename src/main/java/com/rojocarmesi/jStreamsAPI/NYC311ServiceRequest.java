package com.rojocarmesi.jStreamsAPI;

public class NYC311ServiceRequest {

    private int unique_key;
    private String agency;

    public NYC311ServiceRequest() {
    }

    public int getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(int unique_key) {
        this.unique_key = unique_key;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
