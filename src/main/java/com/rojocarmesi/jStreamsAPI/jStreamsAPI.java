package com.rojocarmesi.jStreamsAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import com.sun.jersey.api.client.GenericType;

/**
 * Hello world!
 * http://support.wan.travel/hc/en-us/articles/200191669-Wego-Flights-API
 * https://nycopendata.socrata.com/
 */
public class jStreamsAPI
{
    public static void main(String[] args){
        System.out.println("Welcome to jStreamsAPI!");
        Soda2Consumer consumer = Soda2Consumer.newConsumer("https://data.cityofnewyork.us/");
        SoqlQuery soqlQuery = new SoqlQueryBuilder()
                .setWhereClause("unique_key='29436629'")
                .build();
        List<Map<String, Object>> result = null;
        try {
            result = consumer.query("erm2-nwe9", soqlQuery, new GenericType<List<Map<String, Object>>>(){});
        } catch (SodaError sodaError) {
            sodaError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Map<String, Object> map: result){
            System.out.println("---------------------------------------------------------------------------");
            System.out.print(" | ");
            for(String key: map.keySet()){
                System.out.print(key + ": " + map.get(key) + " | ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Size: " + result.size());
    }
}
