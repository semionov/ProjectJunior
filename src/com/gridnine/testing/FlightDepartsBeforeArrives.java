package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

//  Rule implementation
//  2. flights with segments where arrival date precede departure date are excluded
public class FlightDepartsBeforeArrives implements Rule {
    @Override
    public List<Flight> applyOn(List<Flight> flightList) {
        System.out.println("Рейсы, содержащие сегменты с датой прилёта предшествующей дате вылета исключены: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments()
            .stream()
            .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1)
            .forEach(segment -> list.add(flight)));
        return list;

    }
}
