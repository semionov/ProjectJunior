package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

//  Rule implementation
//  3. Total parking time on the ground does not exceed 2 hours
public class TotalParkingIsLessThan implements Rule {
    int hours = 2;

    public TotalParkingIsLessThan(int hours) {
        this.hours = hours;
    }
    public TotalParkingIsLessThan() {}

    @Override
    public List<Flight> applyOn(List<Flight> flightList) {
        System.out.println("Общий простой на земеле не превышает " + hours + " часа: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> {
            int size = flight.getSegments().size();
            if (size > 1) {
                int hoursCounter = 0;
                for (int i = 1; i < size; i++) {
                    hoursCounter += idleTime(flight.getSegments().get(i - 1).getArrivalDate(),
                        flight.getSegments().get(i).getDepartureDate());
                }
                if (hoursCounter <= hours) {
                    list.add(flight);
                }
            } else {
                list.add(flight);
            }
        });
        return list;
    }

    public int idleTime(LocalDateTime arrival, LocalDateTime departure) {
        return (int) ChronoUnit.HOURS.between(arrival, departure);
    }
}
