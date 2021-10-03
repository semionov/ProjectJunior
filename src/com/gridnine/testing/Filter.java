package com.gridnine.testing;

import java.util.List;

// contains filter function that apply rule on array of flights
public class Filter {
    private Rule rule;
    private List<Flight> flights;

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> filter() {
        return rule.applyOn(flights);
    }
}


