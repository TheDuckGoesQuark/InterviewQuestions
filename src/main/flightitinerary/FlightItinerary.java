package main.flightitinerary;

import java.util.Optional;

/**
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs,
 * and a starting airport, compute the person's itinerary.
 * If no such itinerary exists, return null. All flights must be used in the itinerary.
 * <p>
 * For example, given the following list of flights:
 * <p>
 * HNL ➔ AKL
 * YUL ➔ ORD
 * ORD ➔ SFO
 * SFO ➔ HNL
 * and starting airport YUL, you should return YUL ➔ ORD ➔ SFO ➔ HNL ➔ AKL.
 */
public class FlightItinerary {

    /**
     * Returns a itinerary string array of each airport to stop at in order,
     * or empty optional if no possible itinerary can be created
     *
     * @param flights     origin-destination pairs of airport names, i.e. {@code flights[i][0] -> flights[i][1]}
     * @param homeAirport the airport that the itinerary must start and end at
     * @return a itinerary string array of each airport to stop at in order,
     * or empty optional if no possible itinerary can be created
     */
    public static Optional<String[]> produceItinerary(String[][] flights, String homeAirport) {
        return Optional.empty();
    }
}
