package com.gridnine.testing.junit;

import com.gridnine.testing.Flight;
import com.gridnine.testing.UpcomingFlights;
import com.gridnine.testing.junit.AbstractFlightTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UpcomingFlightsTest extends AbstractFlightTest {
    public UpcomingFlightsTest() {
        super(new UpcomingFlights());
    }

    @Before
    public void setUp() {
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
    }

    @Test
    public void filter() {
        final List<Flight> actualList = ruleTest.applyOn(flights);
        final List<Flight> expectedList = Arrays.asList(flight1, flight3, flight4);
        assertEquals(expectedList, actualList);
        assertEquals(3, actualList.size());
    }
}


