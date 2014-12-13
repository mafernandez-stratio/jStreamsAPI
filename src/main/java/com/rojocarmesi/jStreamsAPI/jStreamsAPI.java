package com.rojocarmesi.jStreamsAPI;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
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
        List<NYC311ServiceRequest> requests = getNYC331ServiceRequests(
                NYC311ServiceRequest.getOrderedKeysOfNYC331ServiceRequests().keySet(),
                0);
        String table = generateStringTable(requests);
        System.out.println(table);
        System.out.println("Size = " + requests.size());
        String createTable = createTableQueryForCrossdata("nycRequests", "cassandra_prod");
        System.out.println(createTable);
    }

    public static List<NYC311ServiceRequest> getNYC331ServiceRequests(Set<String> columns, int limit){
        Soda2Consumer consumer = Soda2Consumer.newConsumer("https://data.cityofnewyork.us/");

        LinkedList<String> cols = new LinkedList<>(columns);

        SoqlQueryBuilder queryBuilder = new SoqlQueryBuilder();
        if(!columns.isEmpty()){
            queryBuilder = queryBuilder.setSelectPhrase(cols);
        }
        if(limit>0){
            queryBuilder = queryBuilder.setLimit(limit);
        }
        SoqlQuery soqlQuery = queryBuilder.build();

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

    private static String generateStringTable(List<NYC311ServiceRequest> requests) {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = NYC311ServiceRequest.getOrderedKeysOfNYC331ServiceRequests().keySet();
        LinkedHashMap<String, Integer> widths = calculateWidths(
                requests,
                keys);
        // Header
        int totalWidth = 0;
        for(String key: keys) {
            int width = widths.get(key);
            sb.append("| ").append(StringUtils.rightPad(key, width)).append(" ");
            totalWidth+=width+3;
        }
        totalWidth+=2;
        sb.append(" |").append(System.lineSeparator());
        String separator = StringUtils.repeat("-", totalWidth);
        sb.append(separator).append(System.lineSeparator());
        // Body
        for(NYC311ServiceRequest request: requests){
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getUnique_key()),
                    widths.get("unique_key"))).append(" ");
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getCreated_date()),
                    widths.get("created_date"))).append(" ");
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getClosed_date()),
                    widths.get("closed_date"))).append(" ");
            sb.append("| ").append(StringUtils.rightPad(
                    request.getAgency(),
                    widths.get("agency"))).append(" ");
            if(request.getAgency() == null){
                sb.append(StringUtils.repeat(" ", widths.get("agency")-"null".length()));
            }
            sb.append("| ").append(StringUtils.rightPad(
                    request.getComplaint_type(),
                    widths.get("complaint_type"))).append(" ");
            if(request.getComplaint_type() == null){
                sb.append(StringUtils.repeat(" ", widths.get("complaint_type")-"null".length()));
            }
            sb.append("| ").append(StringUtils.rightPad(
                    request.getDescriptor(),
                    widths.get("descriptor"))).append(" ");
            if(request.getDescriptor() == null){
                sb.append(StringUtils.repeat(" ", widths.get("descriptor")-"null".length()));
            }
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getIncident_zip()),
                    widths.get("incident_zip"))).append(" ");
            sb.append("| ").append(StringUtils.rightPad(
                    request.getIncident_address(),
                    widths.get("incident_address"))).append(" ");
            if(request.getIncident_address() == null){
                sb.append(StringUtils.repeat(" ", widths.get("incident_address")-"null".length()));
            }
            sb.append("| ").append(StringUtils.rightPad(
                    request.getCity(),
                    widths.get("city"))).append(" ");
            if(request.getCity() == null){
                sb.append(StringUtils.repeat(" ", widths.get("city")-"null".length()));
            }
            sb.append("| ").append(StringUtils.rightPad(
                    request.getStatus(),
                    widths.get("status"))).append(" ");
            if(request.getStatus() == null){
                sb.append(StringUtils.repeat(" ", widths.get("status")-"null".length()));
            }
            sb.append("| ").append(StringUtils.rightPad(
                    request.getBorough(),
                    widths.get("borough"))).append(" ");
            if(request.getBorough() == null){
                sb.append(StringUtils.repeat(" ", widths.get("borough")-"null".length()));
            }
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getX_coordinate_state_plane()),
                    widths.get("x_coordinate_state_plane"))).append(" ");
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getY_coordinate_state_plane()),
                    widths.get("y_coordinate_state_plane"))).append(" ");
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getLatitude()),
                    widths.get("latitude"))).append(" ");
            sb.append("| ").append(StringUtils.rightPad(
                    String.valueOf(request.getLongitude()),
                    widths.get("longitude"))).append(" ");
            sb.append(" |").append(System.lineSeparator());
        }
        sb.append(separator);
        return sb.toString();
    }

    private static LinkedHashMap<String, Integer> calculateWidths(List<NYC311ServiceRequest> requests,
            Set<String> columnNames) {
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
            length = String.valueOf(request.getCity()).length();
            key = iter.next();
            if(length > widths.get(key)){
                widths.put(key, length);
            }
            length = String.valueOf(request.getStatus()).length();
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
        }
        return widths;
    }

    public static String createTableQueryForCrossdata(String tableName, String cluster){
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(tableName).append(" ON CLUSTER ").append(cluster).append(" (");
        LinkedHashMap<String, Class> columns = NYC311ServiceRequest.getOrderedKeysOfNYC331ServiceRequests();
        LinkedList<String> primaryKey = NYC311ServiceRequest.getPrimaryKey();
        Iterator<String> iter = columns.keySet().iterator();
        while(iter.hasNext()){
            String column = iter.next();
            sb.append(column).append(" ").append(convertJavaTypeToCrossdataType(columns.get(column)));
            if(iter.hasNext()){
                sb.append(", ");
            }
        }
        sb.append(", ").append("PRIMARY KEY (").append(
                primaryKey.toString().replace("[", "").replace("]", "")).append(")");
        sb.append(");");
        return sb.toString();
    }

    private static String convertJavaTypeToCrossdataType(Class clazz) {
        String type = "Text";
        if(clazz.getCanonicalName().equalsIgnoreCase(Integer.class.getCanonicalName())) {
            type = "Int";
        } else if (clazz.getCanonicalName().equalsIgnoreCase(Long.class.getCanonicalName())){
            type = "BigInt";
        } else if (clazz.getCanonicalName().equalsIgnoreCase(Float.class.getCanonicalName())){
            type = "Float";
        } else if (clazz.getCanonicalName().equalsIgnoreCase(Double.class.getCanonicalName())){
            type = "Double";
        } else if (clazz.getCanonicalName().equalsIgnoreCase(Boolean.class.getCanonicalName())){
            type = "Boolean";
        }
        return type;
    }

}
