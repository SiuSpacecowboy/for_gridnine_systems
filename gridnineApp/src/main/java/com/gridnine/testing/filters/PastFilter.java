package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;
import java.time.Duration;
import java.util.List;

/** Класс для фильтрации, где имеются сегменты с датой прилёта раньше даты вылета **/
public class PastFilter implements Filter {

    @Override
    public boolean filtering(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (Segment seg : segments) {
            Duration time = Duration.between(seg.getDepartureDate(), seg.getArrivalDate());
            if (time.isNegative()) {
                return false;
            }
        }
        return true;
    }
}
