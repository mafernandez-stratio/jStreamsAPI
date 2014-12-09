package com.rojocarmesi.jStreamsAPI;

public class Location {

    private double latitude;
    private double longitude;

    public Location() {
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

    @Override public String toString() {
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        sb.append(" * ").append(latitude).append(System.lineSeparator());
        sb.append(" * ").append(longitude);
        return sb.toString();
    }
}
