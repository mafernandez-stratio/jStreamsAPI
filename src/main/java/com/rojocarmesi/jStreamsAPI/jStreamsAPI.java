package com.rojocarmesi.jStreamsAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import com.sun.jersey.api.client.GenericType;

/**
 * http://support.wan.travel/hc/en-us/articles/200191669-Wego-Flights-API
 */
public class jStreamsAPI {

    static Logger logger = LoggerFactory.getLogger(jStreamsAPI.class);

    public static void main(String[] args){
        logger.info("Welcome to jStreamsAPI!");

        List<NYC311ServiceRequest> requests = getNYC331ServiceRequests("unique_key", "created_date", "agency");
        NYC311ServiceRequest request = requests.get(0);

        System.out.println(request.getUnique_key());
        System.out.println(request.getCreated_date());
        System.out.println(request.getAgency());

        //List<Map<String, Object>> NYC311ServiceRequests = getNYC331ServiceRequests();
        //LinkedHashSet<String> orderedKeys = getOrderedKeysOfNYC331ServiceRequests();

        //System.out.println(stringResult(NYC311ServiceRequests, orderedKeys));
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
                //.setWhereClause("unique_key='29443051'")
                .setLimit(10)
                .build();
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

    public static int estimateHeaderWidth(LinkedHashSet<String> keys){
        int estimatedWidth = 2;
        for(String key: keys){
            estimatedWidth+=key.length()+2;
        }
        return estimatedWidth;
    }

    public static String stringResult(List<Map<String, Object>> result, LinkedHashSet<String> keys){
        int size = result.size();
        String separator = StringUtils.repeat('-', estimateHeaderWidth(keys));
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        for(Map<String, Object> map: result){
            sb.append(separator).append(System.lineSeparator());
            sb.append("| ");
            for(String key: keys){
                sb.append(key).append(": ").append(map.get(key)).append(" |");
            }
            sb.append(System.lineSeparator());
        }
        sb.append(separator);
        sb.append("Size: ").append(size);
        sb.append(System.lineSeparator());
        return sb.toString();
    }

}
