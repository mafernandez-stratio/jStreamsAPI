package com.rojocarmesi.jStreamsAPI;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class NYC311ServiceRequest {

    private int unique_key;
    private Date created_date;
    private Date closed_date;
    private String agency;
    private String complaint_type;
    private String descriptor;
    private int incident_zip;
    private String incident_address;
    private String city;
    private String status;
    private String borough;
    private float x_coordinate_state_plane;
    private float y_coordinate_state_plane;
    private double latitude;
    private double longitude;

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

    public Date getClosed_date() {
        return closed_date;
    }

    public void setClosed_date(Date closed_date) {
        this.closed_date = closed_date;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getComplaint_type() {
        return complaint_type;
    }

    public void setComplaint_type(String complaint_type) {
        this.complaint_type = complaint_type;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public int getIncident_zip() {
        return incident_zip;
    }

    public void setIncident_zip(String incident_zip) {
        try {
            this.incident_zip = Integer.parseInt(incident_zip);
        } catch (Exception ex) {
            this.incident_zip = 0;
        }
    }

    public String getIncident_address() {
        return incident_address;
    }

    public void setIncident_address(String incident_address) {
        this.incident_address = incident_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public float getX_coordinate_state_plane() {
        return x_coordinate_state_plane;
    }

    public void setX_coordinate_state_plane(float x_coordinate_state_plane) {
        this.x_coordinate_state_plane = x_coordinate_state_plane;
    }

    public float getY_coordinate_state_plane() {
        return y_coordinate_state_plane;
    }

    public void setY_coordinate_state_plane(float y_coordinate_state_plane) {
        this.y_coordinate_state_plane = y_coordinate_state_plane;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public static LinkedHashMap<String, Class> getOrderedKeysOfNYC331ServiceRequests(){
        LinkedHashMap<String, Class> columns = new LinkedHashMap<>();
        columns.put("unique_key", Integer.class);
        columns.put("created_date", Date.class);
        columns.put("closed_date", Date.class);
        columns.put("agency", String.class);
        columns.put("complaint_type", String.class);
        columns.put("descriptor", String.class);
        columns.put("incident_zip", Integer.class);
        columns.put("incident_address", String.class);
        columns.put("city", String.class);
        columns.put("status", String.class);
        columns.put("borough", String.class);
        columns.put("x_coordinate_state_plane", Float.class);
        columns.put("y_coordinate_state_plane", Float.class);
        columns.put("latitude", Double.class);
        columns.put("longitude", Double.class);
        return columns;
    }

    public static LinkedList<String> getPrimaryKey(){
        return new LinkedList<>(Collections.singleton("unique_key"));
    }

    @Override public String toString() {
        String separator = "-------------------------------------------";
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        sb.append(separator).append(System.lineSeparator());
        sb.append(System.lineSeparator());
        return System.lineSeparator() + separator +
                System.lineSeparator() + "unique_key=" + unique_key +
                System.lineSeparator() + "created_date=" + created_date +
                System.lineSeparator() + "closed_date=" + closed_date +
                System.lineSeparator() + "agency='" + agency + '\'' +
                System.lineSeparator() + "complaint_type='" + complaint_type + '\'' +
                System.lineSeparator() + "descriptor='" + descriptor + '\'' +
                System.lineSeparator() + "incident_zip=" + incident_zip +
                System.lineSeparator() + "incident_address='" + incident_address + '\'' +
                System.lineSeparator() + "city='" + city + '\'' +
                System.lineSeparator() + "status='" + status + '\'' +
                System.lineSeparator() + "borough='" + borough + '\'' +
                System.lineSeparator() + "x_coordinate_state_plane=" + x_coordinate_state_plane +
                System.lineSeparator() + "y_coordinate_state_plane=" + y_coordinate_state_plane +
                System.lineSeparator() + "latitude=" + latitude +
                System.lineSeparator() + "longitude=" + longitude +
                System.lineSeparator() + separator +
                System.lineSeparator();
    }
}
