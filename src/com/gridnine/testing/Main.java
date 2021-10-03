package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        Filter filter = new Filter();
        filter.setFlights(flights);
        printFlightList(flights);

        filter.setRule(new UpcomingFlights());
        printFlightList(filter.filter());

        filter.setRule(new FlightDepartsBeforeArrives());
        printFlightList(filter.filter());

        filter.setRule(new TotalParkingIsLessThan(2));
        printFlightList(filter.filter());
    }

    public static void printFlightList(List<Flight> list) {
        list.forEach(System.out::println);
        System.out.println("-----------------------------\n");

    }
}




