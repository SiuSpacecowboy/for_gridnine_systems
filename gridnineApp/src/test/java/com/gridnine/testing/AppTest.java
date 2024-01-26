package com.gridnine.testing;

import com.gridnine.testing.factories.FiltersBuilder;
import com.gridnine.testing.factories.FlightBuilder;
import com.gridnine.testing.filters.*;
import com.gridnine.testing.initializers.FiltersInitializer;
import com.gridnine.testing.models.Flight;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testGroundFilter() {
        List<Boolean> exp = List.of(true, true, true, true, false, false);
        List<Boolean> res = FlightBuilder.createFlights().stream()
                .map(new GroundFilter()::filtering)
                .toList();
       assertArrayEquals(exp.toArray(), res.toArray());
    }

    @Test
    public void testEarlyFilter() {
        List<Boolean> exp = List.of(true, true, false, true, true, true);
        List<Boolean> res = FlightBuilder.createFlights().stream()
                .map(new EarlyFilter()::filtering)
                .toList();
        assertArrayEquals(exp.toArray(), res.toArray());
    }

    @Test
    public void testPastFilter() {
        List<Boolean> exp = List.of(true, true, true, false, true, true);
        List<Boolean> res = FlightBuilder.createFlights().stream()
                .map(new PastFilter()::filtering)
                .toList();
        assertArrayEquals(exp.toArray(), res.toArray());
    }

    @Test
    public void testOneFilter() {
        List<Filter> filters = FiltersBuilder.getFilters(new PastFilter());
        List<Flight> startArray = FlightBuilder.createFlights();
        List<Flight> flightsRes = new FiltersInitializer().filteredList(startArray, filters);
        List<Flight> flightsExp = new ArrayList<>(startArray);
        flightsExp.remove(3);
        assertArrayEquals(flightsExp.toArray(), flightsRes.toArray());
    }

    @Test
    public void testTwoFiltersTogether() {
        List<Filter> filters = FiltersBuilder.getFilters(
                new GroundFilter(),
                new PastFilter());
        List<Flight> startArray = FlightBuilder.createFlights();
        List<Flight> flightsRes = new FiltersInitializer().filteredList(startArray, filters);
        List<Flight> flightsExp = new ArrayList<>(startArray);
        flightsExp = flightsExp.subList(0, 4);
        flightsExp.remove(3);
        assertArrayEquals(flightsExp.toArray(), flightsRes.toArray());
    }

    @Test
    public void testThreeFiltersTogether() {
        List<Filter> filters = FiltersBuilder.getFilters(
                new GroundFilter(),
                new EarlyFilter(),
                new PastFilter());
        List<Flight> startArray = FlightBuilder.createFlights();
        List<Flight> flightsRes = new FiltersInitializer().filteredList(startArray, filters);
        List<Flight> flightsExp = new ArrayList<>(startArray);
        flightsExp = flightsExp.subList(0, 4);
        flightsExp.remove(2);
        flightsExp.remove(2);
        assertArrayEquals(flightsExp.toArray(), flightsRes.toArray());
    }

}