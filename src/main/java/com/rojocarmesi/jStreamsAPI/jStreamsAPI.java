package com.rojocarmesi.jStreamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import com.sun.jersey.api.client.GenericType;

public class jStreamsAPI {

    static Logger logger = LoggerFactory.getLogger(jStreamsAPI.class);

    public static void main(String[] args){
        logger.info("Welcome to jStreamsAPI!");
        List<NYC311ServiceRequest> requests = getNYC331ServiceRequests(new String[]{});
        String table = generateStringTable(requests);
        System.out.println(table);
    }

    public static List<Map<String, Object>> getNYC331ServiceRequests(){
        Soda2Consumer consumer = Soda2Consumer.newConsumer("https://data.cityofnewyork.us/");
        SoqlQuery soqlQuery = new SoqlQueryBuilder()
                .build();
        List<Map<String, Object>> result = null;
        try {
            logger.info("Getting data from NYC - 311 service");
            result = consumer.query("erm2-nwe9", soqlQuery, new GenericType<List<Map<String, Object>>>(){});
        } catch (SodaError sodaError) {
            logger.error("Cannot get data", sodaError);
        } catch (InterruptedException e) {
            logger.error("Cannot get data", e);
        }
        return result;
    }

    public static List<NYC311ServiceRequest> getNYC331ServiceRequests(String... columns){
        Soda2Consumer consumer = Soda2Consumer.newConsumer("https://data.cityofnewyork.us/");
        ArrayList<String> selectClauses = new ArrayList<>(Arrays.asList(columns));
        SoqlQuery soqlQuery = new SoqlQueryBuilder()
                .setSelectPhrase(selectClauses)
                .setLimit(10)
                .build();
        if(columns.length<1){
            soqlQuery = new SoqlQueryBuilder()
                    .setLimit(10)
                    .build();
        }
        List<NYC311ServiceRequest> result = null;
        try {
            logger.info("Getting data from NYC - 311 service");
            result = consumer.query("erm2-nwe9", soqlQuery, new GenericType<List<NYC311ServiceRequest>>(){});
        } catch (SodaError sodaError) {
            logger.error("Cannot get data", sodaError);
        } catch (InterruptedException e) {
            logger.error("Cannot get data", e);
        }
        return result;
    }

    public static LinkedHashSet<String> getOrderedKeysOfNYC331ServiceRequests(){
        LinkedHashSet<String> keys = new LinkedHashSet<>();
        keys.add("unique_key");
        keys.add("created_date");
        keys.add("closed_date");
        keys.add("agency");
        keys.add("agency_name");
        keys.add("complaint_type");
        keys.add("descriptor");
        keys.add("location_type");
        keys.add("incident_zip");
        keys.add("incident_address");
        keys.add("street_name");
        keys.add("cross_street_1");
        keys.add("cross_street_2");
        keys.add("intersection_street_1");
        keys.add("intersection_street_2");
        keys.add("address_type");
        keys.add("city");
        keys.add("landmark");
        keys.add("facility_type");
        keys.add("status");
        keys.add("due_date");
        keys.add("resolution_action_updated_date");
        keys.add("community_board");
        keys.add("borough");
        keys.add("x_coordinate_state_plane");
        keys.add("y_coordinate_state_plane");
        keys.add("park_facility_name");
        keys.add("park_borough");
        keys.add("school_name");
        keys.add("school_number");
        keys.add("school_region");
        keys.add("school_code");
        keys.add("school_phone_number");
        keys.add("school_address");
        keys.add("school_city");
        keys.add("school_state");
        keys.add("school_zip");
        keys.add("school_not_found");
        keys.add("school_or_citywide_complaint");
        keys.add("vehicle_type");
        keys.add("taxi_company_borough");
        keys.add("taxi_pick_up_location");
        keys.add("bridge_highway_name");
        keys.add("bridge_highway_direction");
        keys.add("road_ramp");
        keys.add("bridge_highway_segment");
        keys.add("garage_lot_name");
        keys.add("ferry_direction");
        keys.add("ferry_terminal_name");
        keys.add("latitude");
        keys.add("longitude");
        keys.add("location");
        return keys;
    }

    private static String generateStringTable(List<NYC311ServiceRequest> requests) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, Integer> widths = calculateWidths(requests, getOrderedKeysOfNYC331ServiceRequests());
        //StringUtils.rightPad();
        return sb.toString();
    }

    private static LinkedHashMap<String, Integer> calculateWidths(List<NYC311ServiceRequest> requests,
            LinkedHashSet<String> columnNames) {
        LinkedHashMap<String, Integer> widths = new LinkedHashMap<>();
        for(String columnName: columnNames){
            widths.put(columnName, columnName.length());
        }
        for(NYC311ServiceRequest request: requests){
            int length;
            String key;
            Iterator<String> iter = columnNames.iterator();
            length = String.valueOf(request.getUnique_key()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getCreated_date()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getClosed_date()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getAgency()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getAgency_name()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getComplaint_type()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getDescriptor()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getLocation_type()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getIncident_zip()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getIncident_address()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getStreet_name()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getCross_street_1()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getCross_street_2()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getIntersection_street_1()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getIntersection_street_2()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getAddress_type()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getCity()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getLandmark()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getFacility_type()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getStatus()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getDue_date()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getResolution_action_updated_date()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getCommunity_board()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getBorough()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getX_coordinate_state_plane()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getY_coordinate_state_plane()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getPark_facility_name()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getPark_borough()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_name()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_number()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_region()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_code()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_phone_number()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_address()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_city()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_state()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_zip()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_not_found()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getSchool_or_citywide_complaint()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getVehicle_type()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getTaxi_company_borough()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getTaxi_pick_up_location()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getBridge_highway_name()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getBridge_highway_direction()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getRoad_ramp()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getBridge_highway_segment()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getGarage_lot_name()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getFerry_direction()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getFerry_terminal_name()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getLatitude()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getLongitude()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getLocation()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
        }
        return widths;
    }

    public String getCreateTableQueryForCrossdata(){
        return null;
    }

}
