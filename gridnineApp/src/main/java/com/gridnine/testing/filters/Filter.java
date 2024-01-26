package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;

/** Интерфейс, по шаблону которого создаются все классы фильтрации **/
public interface Filter {

    boolean filtering(Flight flight);
}
