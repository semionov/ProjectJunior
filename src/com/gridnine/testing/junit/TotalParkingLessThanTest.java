package com.gridnine.testing.junit;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Rule;
import com.gridnine.testing.TotalParkingIsLessThan;
import com.gridnine.testing.junit.AbstractFlightTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TotalParkingLessThanTest extends AbstractFlightTest {

    public TotalParkingLessThanTest() {
        super(new TotalParkingIsLessThan());
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
        final List<Flight> expectedList = Arrays.asList(flight1, flight2, flight3);
        assertEquals(expectedList, actualList);
        assertEquals(3, actualList.size());
    }
}