package com.rojocarmesi.jStreamsAPI;

import java.util.Date;

public class NYC311ServiceRequest {

    private int unique_key;
    private Date created_date;
    private Date closed_date;
    private String agency;
    private String agency_name;
    private String complaint_type;
    private String descriptor;
    private String location_type;
    private int incident_zip;
    private String incident_address;
    private String street_name;
    private String cross_street_1;
    private String cross_street_2;
    private String intersection_street_1;
    private String intersection_street_2;
    private String address_type;
    private String city;
    private String landmark;
    private String facility_type;
    private String status;
    private Date due_date;
    private Date resolution_action_updated_date;
    private String community_board;
    private String borough;
    private float x_coordinate_state_plane;
    private float y_coordinate_state_plane;
    private String park_facility_name;
    private String park_borough;
    private String school_name;
    private String school_number;
    private String school_region;
    private String school_code;
    private String school_phone_number;
    private String school_address;
    private String school_city;
    private String school_state;
    private String school_zip;
    private String school_not_found;
    private String school_or_citywide_complaint;
    private String vehicle_type;
    private String taxi_company_borough;
    private String taxi_pick_up_location;
    private String bridge_highway_name;
    private String bridge_highway_direction;
    private String road_ramp;
    private String bridge_highway_segment;
    private String garage_lot_name;
    private String ferry_direction;
    private String ferry_terminal_name;
    private double latitude;
    private double longitude;
    private Location location;

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

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
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

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public int getIncident_zip() {
        return incident_zip;
    }

    public void setIncident_zip(int incident_zip) {
        this.incident_zip = incident_zip;
    }

    public String getIncident_address() {
        return incident_address;
    }

    public void setIncident_address(String incident_address) {
        this.incident_address = incident_address;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCross_street_1() {
        return cross_street_1;
    }

    public void setCross_street_1(String cross_street_1) {
        this.cross_street_1 = cross_street_1;
    }

    public String getCross_street_2() {
        return cross_street_2;
    }

    public void setCross_street_2(String cross_street_2) {
        this.cross_street_2 = cross_street_2;
    }

    public String getIntersection_street_1() {
        return intersection_street_1;
    }

    public void setIntersection_street_1(String intersection_street_1) {
        this.intersection_street_1 = intersection_street_1;
    }

    public String getIntersection_street_2() {
        return intersection_street_2;
    }

    public void setIntersection_street_2(String intersection_street_2) {
        this.intersection_street_2 = intersection_street_2;
    }

    public String getAddress_type() {
        return address_type;
    }

    public void setAddress_type(String address_type) {
        this.address_type = address_type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getResolution_action_updated_date() {
        return resolution_action_updated_date;
    }

    public void setResolution_action_updated_date(Date resolution_action_updated_date) {
        this.resolution_action_updated_date = resolution_action_updated_date;
    }

    public String getCommunity_board() {
        return community_board;
    }

    public void setCommunity_board(String community_board) {
        this.community_board = community_board;
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

    public String getPark_facility_name() {
        return park_facility_name;
    }

    public void setPark_facility_name(String park_facility_name) {
        this.park_facility_name = park_facility_name;
    }

    public String getPark_borough() {
        return park_borough;
    }

    public void setPark_borough(String park_borough) {
        this.park_borough = park_borough;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_number() {
        return school_number;
    }

    public void setSchool_number(String school_number) {
        this.school_number = school_number;
    }

    public String getSchool_region() {
        return school_region;
    }

    public void setSchool_region(String school_region) {
        this.school_region = school_region;
    }

    public String getSchool_code() {
        return school_code;
    }

    public void setSchool_code(String school_code) {
        this.school_code = school_code;
    }

    public String getSchool_phone_number() {
        return school_phone_number;
    }

    public void setSchool_phone_number(String school_phone_number) {
        this.school_phone_number = school_phone_number;
    }

    public String getSchool_address() {
        return school_address;
    }

    public void setSchool_address(String school_address) {
        this.school_address = school_address;
    }

    public String getSchool_city() {
        return school_city;
    }

    public void setSchool_city(String school_city) {
        this.school_city = school_city;
    }

    public String getSchool_state() {
        return school_state;
    }

    public void setSchool_state(String school_state) {
        this.school_state = school_state;
    }

    public String getSchool_zip() {
        return school_zip;
    }

    public void setSchool_zip(String school_zip) {
        this.school_zip = school_zip;
    }

    public String getSchool_not_found() {
        return school_not_found;
    }

    public void setSchool_not_found(String school_not_found) {
        this.school_not_found = school_not_found;
    }

    public String getSchool_or_citywide_complaint() {
        return school_or_citywide_complaint;
    }

    public void setSchool_or_citywide_complaint(String school_or_citywide_complaint) {
        this.school_or_citywide_complaint = school_or_citywide_complaint;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getTaxi_company_borough() {
        return taxi_company_borough;
    }

    public void setTaxi_company_borough(String taxi_company_borough) {
        this.taxi_company_borough = taxi_company_borough;
    }

    public String getTaxi_pick_up_location() {
        return taxi_pick_up_location;
    }

    public void setTaxi_pick_up_location(String taxi_pick_up_location) {
        this.taxi_pick_up_location = taxi_pick_up_location;
    }

    public String getBridge_highway_name() {
        return bridge_highway_name;
    }

    public void setBridge_highway_name(String bridge_highway_name) {
        this.bridge_highway_name = bridge_highway_name;
    }

    public String getBridge_highway_direction() {
        return bridge_highway_direction;
    }

    public void setBridge_highway_direction(String bridge_highway_direction) {
        this.bridge_highway_direction = bridge_highway_direction;
    }

    public String getRoad_ramp() {
        return road_ramp;
    }

    public void setRoad_ramp(String road_ramp) {
        this.road_ramp = road_ramp;
    }

    public String getBridge_highway_segment() {
        return bridge_highway_segment;
    }

    public void setBridge_highway_segment(String bridge_highway_segment) {
        this.bridge_highway_segment = bridge_highway_segment;
    }

    public String getGarage_lot_name() {
        return garage_lot_name;
    }

    public void setGarage_lot_name(String garage_lot_name) {
        this.garage_lot_name = garage_lot_name;
    }

    public String getFerry_direction() {
        return ferry_direction;
    }

    public void setFerry_direction(String ferry_direction) {
        this.ferry_direction = ferry_direction;
    }

    public String getFerry_terminal_name() {
        return ferry_terminal_name;
    }

    public void setFerry_terminal_name(String ferry_terminal_name) {
        this.ferry_terminal_name = ferry_terminal_name;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
