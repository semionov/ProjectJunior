package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//  Rule implementation
//  1. only upcoming flights
public class UpcomingFlights implements Rule {
    private final LocalDateTime now = LocalDateTime.now();
    @Override
    public List<Flight> applyOn(List<Flight> flightList) {
        System.out.println("Только предстоящие рейсы: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments()
            .stream()
            .filter(segment -> segment.getDepartureDate().isAfter(now)).limit(1)
            .forEach(segment -> list.add(flight)));
        return list;
    }
}