package com.gridnine.testing;

import java.util.List;

public interface Rule {
    List<Flight> applyOn(List<Flight> flights);
}
