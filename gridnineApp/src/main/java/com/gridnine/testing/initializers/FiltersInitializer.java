package com.gridnine.testing.initializers;

import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.models.Flight;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Класс отвечающий за работу фильтров, позволяет динамически задавать количество фильтров(от 0 до бесконечности) **/
public class FiltersInitializer {

    public List<Flight> filteredList(List<Flight> flights, List<Filter> filters) {
        return filters.stream()
                .reduce(
                        flights.stream(),
                        (stream, filter) -> stream.filter(filter::filtering),
                        Stream::concat
                )
                .collect(Collectors.toList());
    }
}
