package com.rojocarmesi.jStreamsAPI;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple jStreamsAPI.
 */
public class jStreamsAPITest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public jStreamsAPITest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(jStreamsAPITest.class);
    }

    public void testCreateAndShowQuery() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2014);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.ZONE_OFFSET, -5);
        Date date = calendar.getTime();

        int limit = 0;
        int expectedSize = limit;
        if(limit == 0){
            expectedSize = 1000;
        }
        NYC311ServiceQuery query = new NYC311ServiceQuery();
        int result = query.createAndShowQuery(limit, date).size();
        assertEquals(result, expectedSize);
    }
}
