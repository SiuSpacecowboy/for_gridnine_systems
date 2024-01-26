package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;
import java.time.LocalDateTime;
import java.util.List;

/** Класс для фильтрации, где имеются сегменты с датой прилёта раньше даты вылета **/
public class EarlyFilter implements Filter {

    @Override
    public boolean filtering(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (Segment seg : segments) {
            if (seg.getDepartureDate().isBefore(LocalDateTime.now())) {
                return false;
            }
        }
        return true;
    }
}
