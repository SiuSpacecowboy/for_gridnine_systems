package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;
import java.time.Duration;
import java.util.List;

/** Класс для фильтрации, где общее время, проведённое на земле превышает два часа  **/
public class GroundFilter implements Filter {

    private static final long TWO_HOURS = 7200000;

    @Override
    public boolean filtering(Flight flight) {
        List<Segment> segments = flight.getSegments();
        int segmentCount = 0;
        long groundTime = 0;
        while (groundTime <= TWO_HOURS && segmentCount < segments.size() - 1) {
            Duration time = Duration.between(segments.get(segmentCount).getArrivalDate(),
                    (segments.get(segmentCount + 1).getDepartureDate()));
            if (time.isPositive()) {
                groundTime += time.toMillis();
            }
            segmentCount++;
        }
        return groundTime <= TWO_HOURS;
    }
}
