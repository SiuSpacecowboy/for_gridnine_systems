package com.gridnine.testing;

import com.gridnine.testing.factories.FiltersBuilder;
import com.gridnine.testing.factories.FlightBuilder;
import com.gridnine.testing.filters.EarlyFilter;
import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.filters.GroundFilter;
import com.gridnine.testing.filters.PastFilter;
import com.gridnine.testing.initializers.FiltersInitializer;
import com.gridnine.testing.models.Flight;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Filter groundFilter = new GroundFilter();
        Filter earlyFilter = new EarlyFilter();
        Filter pastFilter = new PastFilter();
        System.out.println("====================PastFilter============================");
        List<Flight> pastFilterFlights = new FiltersInitializer().filteredList(
                FlightBuilder.createFlights(), FiltersBuilder.getFilters(pastFilter));
        pastFilterFlights.forEach(System.out::println);
        System.out.println("====================EarlyFilter===========================");
        List<Flight> earlyFilterFlights =  new FiltersInitializer().filteredList(
                FlightBuilder.createFlights(), FiltersBuilder.getFilters(earlyFilter));
        earlyFilterFlights.forEach(System.out::println);
        System.out.println("====================GroundFilter==========================");
        List<Flight> groundFilterFlights =  new FiltersInitializer().filteredList(
                FlightBuilder.createFlights(), FiltersBuilder.getFilters(groundFilter));
        groundFilterFlights.forEach(System.out::println);
        System.out.println("===================AllFiltersAtOnce=======================");
        List<Flight> allFiltersAtOnce =  new FiltersInitializer().filteredList(
                FlightBuilder.createFlights(), FiltersBuilder.getFilters(groundFilter, earlyFilter, pastFilter));
        allFiltersAtOnce.forEach(System.out::println);
    }
}
