package com.rojocarmesi.jStreamsAPI;

import java.util.Date;

public class NYC311ServiceRequest {

    private int unique_key;
    private Date created_date;
    private String agency;

    public NYC311ServiceRequest() {
    }

    public int getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(int unique_key) {
        this.unique_key = unique_key;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
