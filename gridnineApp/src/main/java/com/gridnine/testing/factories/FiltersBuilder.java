package com.gridnine.testing.factories;

import com.gridnine.testing.filters.Filter;
import java.util.Arrays;
import java.util.List;

/** Класс для создания удобной инициализации всех нужных фильтров **/
public class FiltersBuilder {

    public static List<Filter> getFilters(final Filter... filters) {
        return Arrays.stream(filters).toList();
    }
}
